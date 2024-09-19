package com.example.hom_thu_dien_tu.controller;

import com.example.hom_thu_dien_tu.Repository.ISettingsRepository;
import com.example.hom_thu_dien_tu.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SettingsController {

    @Autowired
    private ISettingsRepository settingsRepository;

    @GetMapping("/")
    public String showSettingsList(Model model) {
        Settings settings = new Settings();
        model.addAttribute("settings", settings);
        return "settingsForm";
    }

    @PostMapping("/updateSettings")
    public String saveSettings(@ModelAttribute("settings") Settings settings) {
        settingsRepository.save(settings);
        return "redirect:/listSettings";
    }

    @GetMapping("/listSettings")
    public String listSettings(Model model) {
        List<Settings> settingsList = settingsRepository.getAllSettings();
        model.addAttribute("settingsList", settingsList);
        return "settingsList";
    }
}

