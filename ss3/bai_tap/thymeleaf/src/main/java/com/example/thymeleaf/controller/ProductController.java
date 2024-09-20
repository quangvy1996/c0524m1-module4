package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Product;
import com.example.thymeleaf.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String listProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String viewProductDetails(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "details";
    }

    @GetMapping("/search")
    public String searchProductByName(@RequestParam("name") String name, Model model) {
        List<Product> products = productService.searchByName(name);
        model.addAttribute("products", products);
        return "list";
    }
}

