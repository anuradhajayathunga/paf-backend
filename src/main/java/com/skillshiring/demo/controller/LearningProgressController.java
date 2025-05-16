package com.skillshiring.demo.controller;

import com.skillshiring.demo.models.LearningProgress;
import com.skillshiring.demo.models.User;
import com.skillshiring.demo.service.LearningProgressService;
import com.skillshiring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin // Optional: only add if your frontend is on another origin
public class LearningProgressController {

    @Autowired
    private LearningProgressService service;

    @Autowired
    private UserService userService;

    // ✅ Create a new learning progress entry
    @PostMapping
    public ResponseEntity<LearningProgress> create(
            @RequestHeader("Authorization") String token,
            @RequestBody LearningProgress progress) throws Exception {

        User reqUser = userService.findUserByJwtToken(token);
        LearningProgress created = service.create(progress, reqUser.getId());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // ✅ Get all progress of the authenticated user
    @GetMapping("/me")
    public ResponseEntity<List<LearningProgress>> getMyProgress(
            @RequestHeader("Authorization") String token) throws Exception {

        User reqUser = userService.findUserByJwtToken(token);
        List<LearningProgress> progressList = service.getAllByUser(reqUser.getId());
        return ResponseEntity.ok(progressList);
    }

    // ✅ Update a specific progress entry
    @PutMapping("/{id}")
    public ResponseEntity<LearningProgress> update(
            @PathVariable Integer id,
            @RequestBody LearningProgress progress) {

        LearningProgress updated = service.update(id, progress);
        return ResponseEntity.ok(updated);
    }

    // ✅ Delete a specific progress entry
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Learning Progress deleted successfully.", HttpStatus.OK);
    }
}
