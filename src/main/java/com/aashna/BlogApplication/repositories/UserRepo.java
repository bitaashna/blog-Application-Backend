package com.aashna.BlogApplication.repositories;

import com.aashna.BlogApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
