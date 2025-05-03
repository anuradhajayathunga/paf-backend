package com.photolearn.learningplatform.service;

import com.photolearn.learningplatform.entity.LearningProgress;
import com.photolearn.learningplatform.repository.LearningProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningProgressService {

    @Autowired
    private LearningProgressRepository repo;

    // Create new progress
    public LearningProgress create(LearningProgress progress) {
        return repo.save(progress);
    }

    // Get all progress for a specific user
    public List<LearningProgress> getAllByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    // Update existing progress
    public LearningProgress update(Long id, LearningProgress updated) {
        LearningProgress existing = repo.findById(id).orElseThrow();

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setCompletedDate(updated.getCompletedDate());

        // New fields updates
        existing.setDuration(updated.getDuration());
        existing.setStatus(updated.getStatus());
        existing.setCategory(updated.getCategory());
        existing.setReflections(updated.getReflections());
        existing.setResources(updated.getResources());

        return repo.save(existing);
    }

    // Delete progress
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
