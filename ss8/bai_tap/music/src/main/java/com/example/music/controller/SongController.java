package com.example.music.controller;

import com.example.music.dto.SongDto;
import com.example.music.model.Song;
import com.example.music.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("songs",songService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("song",new Song());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("song") SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "add success");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String editSong(@Valid @ModelAttribute("song") SongDto songDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,@PathVariable("id") Long id) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song existingSong = songService.findById(id);
        if (existingSong != null) {
            BeanUtils.copyProperties(songDto, existingSong);
            songService.save(existingSong);
            redirectAttributes.addFlashAttribute("mess", "Update success");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Song not found");
            return "redirect:/";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id) {
        songService.deleteById(id);
        return "redirect:/";
    }
}
