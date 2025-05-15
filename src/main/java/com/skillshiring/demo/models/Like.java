package com.skillshiring.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;
    private Long userId;
    private LocalDateTime likedAt;

    // Getters and Setters
}
