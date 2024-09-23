package com.example.hom_thu_dien_tu.controller;

import com.example.hom_thu_dien_tu.repository.ISettingsRepository;
import com.example.hom_thu_dien_tu.model.Settings;
import com.example.hom_thu_dien_tu.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SettingsController {

    @Autowired
    private ISettingsService settingsService;

    @GetMapping("/")
    public String showSettingsList(Model model) {
        Settings settings = new Settings();
        model.addAttribute("settings", settings);
        return "settingsForm";
    }

    @PostMapping("/updateSettings")
    public String saveSettings(@ModelAttribute("settings") Settings settings) {
        settingsService.save(settings);
        return "redirect:/listSettings";
    }

    @GetMapping("/listSettings")
    public String listSettings(Model model) {
        List<Settings> settingsList = settingsService.getAllSettings();
        model.addAttribute("settingsList", settingsList);
        return "settingsList";
    }
}

