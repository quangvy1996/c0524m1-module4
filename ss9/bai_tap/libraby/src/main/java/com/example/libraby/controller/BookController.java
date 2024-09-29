package com.example.libraby.controller;


import com.example.libraby.model.Book;
import com.example.libraby.service.BookService;
import com.example.libraby.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.listBooks());
        return "book/list";
    }

    @GetMapping("/borrow/{title}")
    public String borrowBook(@PathVariable String title, Model model) {
        String borrowId = bookService.borrowBook(title);
        model.addAttribute("borrowId", borrowId);
        return "book/details";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String borrowId, Model model) {
        bookService.returnBook(borrowId);
        return "redirect:/books";
    }
}


