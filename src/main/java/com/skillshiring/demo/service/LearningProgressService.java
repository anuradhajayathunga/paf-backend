package com.skillshiring.demo.service;

import com.skillshiring.demo.Repository.LearningProgressRepository;
import com.skillshiring.demo.models.LearningProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningProgressService {

    @Autowired
    private LearningProgressRepository repo;

    // Create new progress
    public LearningProgress create(LearningProgress progress, Integer userId) {
        progress.setUserId(userId);
        return repo.save(progress);
    }

    // Get all progress for a specific user
    public List<LearningProgress> getAllByUser(Integer userId) {
        return repo.findByUserId(userId);
    }

    // Update existing progress
    public LearningProgress update(Integer id, LearningProgress updated) {
        LearningProgress existing = repo.findById(id).orElseThrow();

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setCompletedDate(updated.getCompletedDate());
        existing.setStartDate(updated.getStartDate()); // <-- Add this line


        // New fields updates
        existing.setDuration(updated.getDuration());
        existing.setStatus(updated.getStatus());
        existing.setCategory(updated.getCategory());
        existing.setReflections(updated.getReflections());
        existing.setResources(updated.getResources());

        return repo.save(existing);
    }

    // Delete progress
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
