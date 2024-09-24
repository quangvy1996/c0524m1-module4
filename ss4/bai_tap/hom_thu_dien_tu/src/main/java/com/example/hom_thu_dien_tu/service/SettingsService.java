package com.example.hom_thu_dien_tu.service;

import com.example.hom_thu_dien_tu.model.Settings;
import com.example.hom_thu_dien_tu.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SettingsService implements ISettingsService {
    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public List<Settings> getAllSettings() {
        return settingsRepository.getAllSettings();
    }

    @Override
    public void save(Settings settings) {
        settingsRepository.save(settings);
    }
}
