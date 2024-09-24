package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }
    @GetMapping("/create")
    public String createPostForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/new")
    public String createPost(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/{id}")
    public String readPost(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }
    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Blog blog) {
        blog.setId(id);
        blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        blogService.deleteById(id);
        return "redirect:/blog";
    }
}
