package com.aashna.BlogApplication.services.impl;

import com.aashna.BlogApplication.model.Category;
import com.aashna.BlogApplication.payloads.CategoryDto;
import com.aashna.BlogApplication.repositories.CategoryRepo;
import com.aashna.BlogApplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategoryById(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).get();
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCat = this.categoryRepo.save(cat);

        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategoryById(Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId).get();
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId).get();
        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = this.categoryRepo.findAll();

        List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());

        return catDtos;
    }

}