package com.skillshiring.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String comment;

//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<User> likes=new ArrayList<>();


    private LocalDateTime createdAt;

    public Comment() {}

    public Comment(Integer id, String comment, User user, List<User> likes, LocalDateTime createdAt) {
        this.id = id;
        this.comment = comment;
        this.user = user;
        this.likes = likes;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
