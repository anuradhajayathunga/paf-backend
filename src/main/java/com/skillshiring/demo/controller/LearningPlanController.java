package com.skillshiring.demo.controller;

import com.skillshiring.demo.models.LearningPlan;
import com.skillshiring.demo.models.User;
import com.skillshiring.demo.service.LearningPlanService;
import com.skillshiring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class LearningPlanController {

    @Autowired
    private LearningPlanService learningPlanService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<LearningPlan> createLearningPlan(
            @RequestHeader("Authorization") String token,
            @RequestBody LearningPlan plan) throws Exception {

        User reqUser = userService.findUserByJwtToken(token);
        LearningPlan created = learningPlanService.create(plan, reqUser.getId());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<LearningPlan>> getAllByUser(@RequestHeader("Authorization") String token) throws Exception {
        User reqUser = userService.findUserByJwtToken(token);
        List<LearningPlan> plans = learningPlanService.getAllByUser(reqUser.getId());
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LearningPlan> getById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(learningPlanService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningPlan> update(@PathVariable Integer id,
                                               @RequestBody LearningPlan plan) throws Exception {
        return new ResponseEntity<>(learningPlanService.update(id, plan), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        learningPlanService.delete(id);
        return new ResponseEntity<>("Learning plan deleted successfully.", HttpStatus.OK);
    }
}
