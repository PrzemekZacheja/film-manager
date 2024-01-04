package com.filmmanager.infrastructure.filmreceiver.controller;

import com.filmmanager.domain.filmreceiver.dto.FilmListResponseDto;
import com.filmmanager.domain.filmreceiver.dto.FilmResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class FilmController {

    @GetMapping("/film/{title}")
    public ResponseEntity<FilmResponseDto> getFilmByTitle(@PathVariable String title, @RequestHeader(required = false) boolean favorite) {
        return ResponseEntity.ok()
                             .body(new FilmResponseDto());
    }

    @GetMapping("/films")
    public ResponseEntity<FilmListResponseDto> getAllFilms() {
        return ResponseEntity.ok()
                             .body(new FilmListResponseDto(Collections.emptyList()));
    }
}