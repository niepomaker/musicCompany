package com.example.MusicCompany.controller;

import com.example.MusicCompany.model.Album;
import com.example.MusicCompany.repository.AlbumRepository;
import com.example.MusicCompany.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/app")
public class OfferController {

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;

    @GetMapping("/oferta")
    public String showAllAlbums(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "oferta";
    }

    @GetMapping("/details")
    public String showAlbum(@RequestParam Long id, Model model) {
        model.addAttribute("album", albumRepository.findById(id));
        return "oneAlbum";
    }


}