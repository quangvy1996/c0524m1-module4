package com.example.hom_thu_dien_tu.service;

import com.example.hom_thu_dien_tu.model.Settings;

import java.util.List;

public interface ISettingsService {
    List<Settings> getAllSettings();
    void save(Settings settings);
}
