package com.example.thymeleaf.service;

import com.example.thymeleaf.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private static Map<Integer, Product> map = new HashMap<>();

    static {
        map.put(1, new Product(1, "Dell", 1200.0, "Gaming Laptop", "VN"));
        map.put(2, new Product(2, "Hp", 1100.0, "Working Laptop", "USA"));
        map.put(3, new Product(3, "Asus", 1000.0, "Design Laptop", "China"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }

    @Override
    public void save(Product product) {
        map.put(product.getId(), product);
    }
    @Override
    public void delete(int id) {
        map.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : map.values()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                products.add(product);
            }
        }
        return products;
    }
}
