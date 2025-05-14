package com.skillshiring.demo.Repository;

import com.skillshiring.demo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {


}
