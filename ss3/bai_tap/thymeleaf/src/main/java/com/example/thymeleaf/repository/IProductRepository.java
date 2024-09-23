package com.example.thymeleaf.repository;

import com.example.thymeleaf.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void delete(int id);
    List<Product> searchByName(String name);}
