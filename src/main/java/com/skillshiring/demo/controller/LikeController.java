package com.skillshiring.demo.controller;

const Like = require('../models/Like');
const Post = require('../models/Post');
const notificationService = require('../services/notificationService');

const likePost = async (req, res) => {
        try {
        const { postId } = req.params;
    const userId = req.user._id;

// Check if already liked
    const existingLike = await Like.findOne({ user: userId, post: postId });
        if (existingLike) {
// Unlike: Remove like
await Like.deleteOne({ _id: existingLike._id });
await Post.updateOne({ _id: postId }, { $pull: { likes: existingLike._id } });
        return res.json({ message: 'Post unliked' });
        }

        // Like: Create new like
        const like = new Like({ user: userId, post: postId });
await like.save();
await Post.updateOne({ _id: postId }, { $push: { likes: like._id } });

        // Create notification
        const post = await Post.findById(postId);
    if (post.user.toString() !== userId.toString()) {
await notificationService.createNotification({
    recipient: post.user,
            sender: userId,
            type: 'like',
            post: postId,
            content: `${req.user.username} liked your post.`,
});
        }

        res.json({ message: 'Post liked', like });
        } catch (error) {
        res.status(500).json({ message: 'Server error', error });
        }
        };

module.exports = { likePost };
