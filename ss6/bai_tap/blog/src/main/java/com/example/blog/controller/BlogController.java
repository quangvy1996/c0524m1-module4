package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.blog_service.IBlogService;
import com.example.blog.service.category_service.CategoryService;
import com.example.blog.service.category_service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService iCategoryService;
@ModelAttribute("categories")
public List<Category> getCategories() {
    return iCategoryService.getAllCategories();
}
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String searchTitle,
                           Model model) {

        Sort sort = Sort.by("title").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Blog> blogPage = blogService.findBlogByTitleContaining(searchTitle,pageable);
//        List<Blog> blogList = blogService.findAll();
        blogPage.forEach(blog -> {
            if (blog.getContent().length() > 100) {
                blog.setSummary(blog.getContent().substring(0, 100) + "...");
            } else {
                blog.setSummary(blog.getContent());
            }
        });
//        model.addAttribute("blogList", blogList);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchTitle", searchTitle);
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
