package com.aashna.BlogApplication.services;

import com.aashna.BlogApplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    // CREATE
    CategoryDto createCategory(CategoryDto categoryDto);

    // UPDATE
    CategoryDto updateCategoryById(CategoryDto categoryDto, Integer categoryId);

    // DELETE
    void deleteCategoryById(Integer categoryId);

    // GET
    CategoryDto getCategoryById(Integer categoryId);

    // GET ALL
    List<CategoryDto> getAllCategories();

}
