package com.photolearn.learningplatform.controller;

import com.photolearn.learningplatform.entity.LearningProgress;
import com.photolearn.learningplatform.service.LearningProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/progress")
public class LearningProgressController {

    @Autowired
    private LearningProgressService service;

    @PostMapping
    public LearningProgress create(@RequestBody LearningProgress progress) {
        return service.create(progress);
    }

    @GetMapping("/user/{userId}")
    public List<LearningProgress> getByUser(@PathVariable Long userId) {
        return service.getAllByUser(userId);
    }

    @PutMapping("/{id}")
    public LearningProgress update(@PathVariable Long id, @RequestBody LearningProgress progress) {
        return service.update(id, progress);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
        
        
    }
}
