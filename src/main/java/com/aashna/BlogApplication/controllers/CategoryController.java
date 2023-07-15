package com.aashna.BlogApplication.controllers;

import com.aashna.BlogApplication.payloads.ApiResponse;
import com.aashna.BlogApplication.payloads.CategoryDto;
import com.aashna.BlogApplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // CREATE
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);

    }

    // UPDATE
    @PutMapping("/{catid}")
    public ResponseEntity<CategoryDto> updateCategoryById(@Valid @PathVariable Integer catid,
                                                          @RequestBody CategoryDto categoryId) {
        CategoryDto updatedCategory = this.categoryService.updateCategoryById(categoryId, catid);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);

    }

    // DELETE
    @DeleteMapping("/{catid}")
    public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Integer catid) {
        this.categoryService.deleteCategoryById(catid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
                HttpStatus.OK);

    }

    // GET BY ID
    @GetMapping("/{catid}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catid) {
        CategoryDto categoryDtos = this.categoryService.getCategoryById(catid);
        return new ResponseEntity<CategoryDto>(categoryDtos, HttpStatus.OK);
    }

    // GET ALL
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categories);

    }

}
