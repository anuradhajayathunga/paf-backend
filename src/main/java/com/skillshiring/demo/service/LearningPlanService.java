package com.skillshiring.demo.service;

import com.skillshiring.demo.Repository.LearningPlanRepository;
import com.skillshiring.demo.models.LearningPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningPlanService {

    @Autowired
    private LearningPlanRepository repo;

    public LearningPlan create(LearningPlan plan, Integer userId) {
        plan.setUserId(userId); // associate with current user
        return repo.save(plan);
    }

    public List<LearningPlan> getAllByUser(Integer userId) {
        return repo.findByUserId(userId);
    }
    public LearningPlan getById(Integer id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("Learning plan not found with id " + id));
    }

    public LearningPlan update(Integer id, LearningPlan updatedPlan) throws Exception {
        LearningPlan existing = getById(id);

        existing.setTitle(updatedPlan.getTitle());
        existing.setDescription(updatedPlan.getDescription());
        existing.setResourceLink(updatedPlan.getResourceLink());
        existing.setTimeline(updatedPlan.getTimeline());
        existing.setStatus(updatedPlan.getStatus());
        existing.setTopicsJson(updatedPlan.getTopicsJson());

        return repo.save(existing);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
