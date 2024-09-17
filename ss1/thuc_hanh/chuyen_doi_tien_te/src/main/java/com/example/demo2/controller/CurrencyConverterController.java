package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {

    @RequestMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/convert")
    public String convertCurrency(@RequestParam("exchangeRate") double exchangeRate,
                                  @RequestParam("usdAmount") double usdAmount,
                                  Model model) {
        double vndAmount = usdAmount * exchangeRate;
        model.addAttribute("usdAmount", usdAmount);
        model.addAttribute("vndAmount", vndAmount);
        model.addAttribute("exchangeRate", exchangeRate);
        return "result";
    }
}

