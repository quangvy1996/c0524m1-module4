package com.example.music.service;

import com.example.music.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(Long id);
    void deleteById(Long id);
}
