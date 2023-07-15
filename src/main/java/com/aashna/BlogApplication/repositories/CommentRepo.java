package com.aashna.BlogApplication.repositories;

import com.aashna.BlogApplication.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}