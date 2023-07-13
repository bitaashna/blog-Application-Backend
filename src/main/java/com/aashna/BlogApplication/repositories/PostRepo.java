package com.aashna.BlogApplication.repositories;

import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(Integer userId);

    @Query("SELECT p FROM Post p where p.title like :key")
    List<Post> searchByTitle(@Param("key") String title);
}
