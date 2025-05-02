package com.skillshiring.demo.service;

import com.skillshiring.demo.Repository.CommentRepo;
import com.skillshiring.demo.Repository.PostRepo;
import com.skillshiring.demo.models.Comment;
import com.skillshiring.demo.models.Post;
import com.skillshiring.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImplement implements CommentService {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepo postRepo;

    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {
        User user = userService.findUserById(userId);
        Post post = postService.findPostById(postId);
        comment.setUser(user);
        comment.setComment(comment.getComment());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepo.save(comment);
        post.getComments().add(savedComment);
        postRepo.save(post);

        return savedComment;
    }

    @Override
    public Comment findCommentById(Integer commentId) throws Exception {
        Optional<Comment> opt= commentRepo.findById(commentId);
        if(opt.isEmpty()){
            throw new Exception("Comment not found");
        }

        return opt.get();
    }

    @Override
    public Comment likeComment(Integer CommentId, Integer userId) throws Exception {
        Comment comment=findCommentById(CommentId);
        User user = userService.findUserById(userId);
        if (!comment.getLikes().contains(user)) {
            comment.getLikes().add(user);
        }
        else comment.getLikes().remove(user);

        return commentRepo.save(comment);
    }
}
