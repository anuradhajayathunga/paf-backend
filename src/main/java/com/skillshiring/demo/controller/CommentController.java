package com.skillshiring.demo.controller;

import com.skillshiring.demo.models.Comment;
import com.skillshiring.demo.models.User;
import com.skillshiring.demo.service.CommentService;
import com.skillshiring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;


    @PostMapping("/api/comments/post/{postId}")
    public Comment createComment(@PathVariable Integer postId, @RequestHeader("Authorization") String token,
                                 @RequestBody Comment comment) throws Exception {
        User reqUser = userService.findUserByJwtToken(token);
        return commentService.createComment(comment,postId,reqUser.getId());
    }


    @PutMapping("/api/comments/like/{commentId}")
    public Comment likeAComment( @RequestHeader("Authorization") String jwt,@PathVariable Integer commentId) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Comment likedComment = commentService.likeComment(commentId,user.getId());
        return likedComment;
    }
}
