package com.example.order.service;

import com.example.order.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    void deleteById(Long id);
}
