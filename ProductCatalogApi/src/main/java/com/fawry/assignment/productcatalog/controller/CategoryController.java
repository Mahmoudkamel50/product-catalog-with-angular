package com.fawry.assignment.productcatalog.controller;

import com.fawry.assignment.productcatalog.dto.request.CategoryRequestDto;
import com.fawry.assignment.productcatalog.dto.response.CategoryResponseDto;
import com.fawry.assignment.productcatalog.mapper.CategoryMapper;
import com.fawry.assignment.productcatalog.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDto addCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        return CategoryMapper.INSTANCE.toResponseDto(this.categoryService.addCategory(CategoryMapper.INSTANCE.toCategory(categoryRequestDto)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponseDto> getAllCategories(){
        List<CategoryResponseDto> responseDto = new ArrayList<>();
        this.categoryService.getAll().forEach(category -> responseDto.add(CategoryMapper.INSTANCE.toResponseDto(category)));
        return responseDto;
    }
}
