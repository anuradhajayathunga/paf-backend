package com.skillshiring.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LearningPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer userId;
    private String title;
    private String description;
    private String resourceLink;
    private String timeline;
    private String status;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String topicsJson;

}
