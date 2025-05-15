package com.skillshiring.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long recipientId;
    private String type; // "like" or "comment"
    private String message;
    private boolean isRead;
    private LocalDateTime createdAt;

    // Getters and Setters
}
