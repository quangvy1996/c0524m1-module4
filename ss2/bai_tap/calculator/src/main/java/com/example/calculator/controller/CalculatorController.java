package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculation(@RequestParam double first, @RequestParam double second, @RequestParam String operation, Model model) {

        try {
            double result = calculatorService.calculate(first, second, operation);
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("result", e.getMessage());
        }
        return "index";
    }
}
