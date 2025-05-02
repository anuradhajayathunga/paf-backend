package com.skillshiring.demo.service;

import com.skillshiring.demo.models.Comment;

public interface CommentService {

    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception;

    public Comment findCommentById(Integer commentId) throws Exception;

    public Comment likeComment(Integer CommentId, Integer userId) throws Exception;
}