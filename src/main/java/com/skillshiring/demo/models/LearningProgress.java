package com.skillshiring.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LearningProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String title;
    private String description;
    private LocalDate completedDate; // This is your "date" field from frontend
    private LocalDate startDate;     // New Field: Start date from frontend

    private Integer duration;  // New Field: in minutes
    private String status;     // New Field: "Not Started", "In Progress", "Completed"
    private String category;   // New Field: Programming, Design, etc
    @Column(length = 1000)      // Optional: make bigger
    private String reflections; // New Field: text area
    @Column(length = 1000)      // Optional: make bigger
    private String resources;   // New Field: text area

}