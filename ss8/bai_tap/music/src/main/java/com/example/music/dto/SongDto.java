package com.example.music.dto;

import com.example.music.service.ISongService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
public class SongDto implements Validator {
    private static final String NAME_REGEX = "^[^@;.,=+\\-]+$";
    private static final String ARTIST_REGEX = "^[^@;.,=+\\-]+$";
    private static final String CATEGORY_REGEX = "^[^@;.=+\\-]+(,)?$";

    private Long id;
    private String name;
    private String artist;
    private String category;

    public SongDto(Long id, String name, String artist, String category) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if ("".equals(songDto.getName())) {
            errors.rejectValue("name", "Empty", "Name is required");
        }
        else if (songDto.getName().length() > 800) {
            errors.rejectValue("name", "song.name.size", "Song name limit is 800 characters");
        }
        else if (!songDto.getName().matches(NAME_REGEX)) {
            errors.rejectValue("name", "song.name.invalid", "Song name do not contain @ ; , . = - +");
        }
        if("".equals(songDto.getArtist())) {
            errors.rejectValue("artist", "Empty", "Artist is required");
        }
        else if (songDto.getArtist().length() > 300) {
            errors.rejectValue("artist", "song.artist.size", "Artist name limit is 300 characters");
        }
        else if (!songDto.getArtist().matches(ARTIST_REGEX)) {
            errors.rejectValue("artist", "song.artist.invalid", "Artist name do not contain @ ; , . = - +");
        }
        if("".equals(songDto.getCategory())) {
            errors.rejectValue("category", "Empty", "Category is required");
        }
        else if (songDto.getCategory().length() > 1000) {
            errors.rejectValue("category", "song.category.size", "Category name limit is 1000 characters");
        }
        else if (!songDto.getCategory().matches(CATEGORY_REGEX)) {
            errors.rejectValue("category", "song.category.invalid", "Category name do not contain @ ; , . = - +");
        }
    }
}
