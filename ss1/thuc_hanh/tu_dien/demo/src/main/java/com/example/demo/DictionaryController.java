package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
@Controller

public class DictionaryController {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam("words") String word, Model model) {
        String meaning = dictionary.get(word.toLowerCase().trim());
        System.out.println(meaning);
        if (meaning == null) {
            meaning = "Không tìm thấy từ";
        }
        model.addAttribute("meaning", meaning);
        return "index";
    }
}
