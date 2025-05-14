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

    @Query("select p from Post p where p.caption like %:query% or p.category like %:query% or p.keywords like %:query%")
    public List<Post> searchPost(@Param("query") String query);


}
