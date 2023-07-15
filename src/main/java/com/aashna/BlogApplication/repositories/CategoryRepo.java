package com.aashna.BlogApplication.repositories;

import com.aashna.BlogApplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer>
{


}