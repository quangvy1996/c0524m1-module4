package com.example.demo.controller;

import com.example.demo.sevice.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam("words") String word, Model model) {
        String meaning = dictionaryService.translate(word);
        model.addAttribute("meaning", meaning);
        model.addAttribute("enteredWord", word);
        return "index";
    }
}
