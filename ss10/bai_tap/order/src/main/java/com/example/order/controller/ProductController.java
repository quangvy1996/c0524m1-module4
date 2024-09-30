package com.example.order.controller;


import com.example.order.model.Cart;
import com.example.order.model.Product;
import com.example.order.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id,
                                 @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            cart.decreaseProductQuantity(productOptional.get());
        }
        return "redirect:/shopping-cart";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteFromCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        ModelAndView modalAndView = new ModelAndView("cart");
        Optional<Product> productOptional = productService.findById(id);
        System.out.println(cart);
        if (productOptional.isPresent()) {
            cart.deleteProduct(productOptional.get());
        }
        return modalAndView;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showProductDetail(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        if (productOptional.isPresent()) {
            modelAndView.addObject("product", productOptional.get());
        } else {
            modelAndView.setViewName("/error_404");
        }
        return modelAndView;
    }
    @GetMapping("/checkout")
    public String checkout(@ModelAttribute Cart cart) {
        cart.checkout();
        return "redirect:/payment-success";
    }

}