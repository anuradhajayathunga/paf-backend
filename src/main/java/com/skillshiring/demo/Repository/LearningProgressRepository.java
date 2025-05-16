package com.skillshiring.demo.Repository;

import com.skillshiring.demo.models.LearningProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearningProgressRepository extends JpaRepository<LearningProgress, Integer> {
    List<LearningProgress> findByUserId(Integer userId);

}
