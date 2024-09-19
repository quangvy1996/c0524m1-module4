package com.example.hom_thu_dien_tu.Repository;

import com.example.hom_thu_dien_tu.model.Settings;

import java.util.List;

public interface ISettingsRepository {
     List<Settings> getAllSettings();
     void save(Settings settings);
}
