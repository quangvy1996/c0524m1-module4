package com.example.hom_thu_dien_tu.Repository;

import com.example.hom_thu_dien_tu.model.Settings;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingsRepository implements ISettingsRepository {
    private List<Settings> settingsList = new ArrayList<>();

    @Override
    public List<Settings> getAllSettings() {
        return new ArrayList<>(settingsList);
    }
    @Override
    public void save(Settings settings) {
        settingsList.add(settings);
    }
}
