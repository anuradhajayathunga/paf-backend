package com.skillshiring.demo.Repository;

import com.skillshiring.demo.models.Post;
import com.skillshiring.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.user.id=:userId")
    List<Post> findPostBYUserId(Integer userId);

    @Query("SELECT DISTINCT p FROM Post p " +
            "LEFT JOIN p.keywords k " +
            "WHERE LOWER(p.caption) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(p.category) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(k) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Post> searchPost(@Param("query") String query);



}
