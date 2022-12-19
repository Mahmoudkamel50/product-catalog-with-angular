package com.fawry.assignment.productcatalog.service;


import com.fawry.assignment.productcatalog.repository.entity.Category;
import com.fawry.assignment.productcatalog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category addCategory(Category category){
         return this.categoryRepository.save(category);
    }

    public Category findByName(String name){
        return this.categoryRepository.findCategoryByName(name);
    }

    public List<Category> getAll(){
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("Dose Not Exist");
        });
    }
}
