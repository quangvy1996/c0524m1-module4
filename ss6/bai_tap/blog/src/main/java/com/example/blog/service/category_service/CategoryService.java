package com.example.blog.service.category_service;

import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
  private ICategoryRepository icategoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return icategoryRepository.findAll();
    }


}
