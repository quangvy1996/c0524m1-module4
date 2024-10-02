package com.example.blog.service.blog_service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    void save(Blog blog);
    void deleteById(Long id);
    Page<Blog> findBlogByTitleContaining(String title, Pageable pageable);

}
