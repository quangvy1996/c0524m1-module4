package com.example.demo.sevice;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
    }

    public String translate(String word) {
        String meaning = dictionary.get(word.toLowerCase());
        if (meaning == null) {
            return "Không tìm thấy từ";
        }
        return meaning;
    }
}
