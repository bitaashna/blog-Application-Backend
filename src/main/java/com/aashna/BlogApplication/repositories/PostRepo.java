package com.aashna.BlogApplication.repositories;

import com.aashna.BlogApplication.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
