package com.filmmanager.infrastructure.filmreceiver.controller;

import com.filmmanager.domain.filmreceiver.FilmFacade;
import com.filmmanager.domain.filmreceiver.dto.FilmListResponseDto;
import com.filmmanager.domain.filmreceiver.dto.FilmResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class FilmController {

    @Autowired
    FilmFacade filmFacade;

    @GetMapping("/film/{title}")
    public ResponseEntity<FilmResponseDto> getFilmByTitle(@PathVariable String title, @RequestHeader(required = false) boolean favorite) {
        FilmResponseDto filmResponseDto = filmFacade.fetchFilmByTitle(title);
        return ResponseEntity.ok()
                             .body(filmResponseDto);
    }

    @GetMapping("/films")
    public ResponseEntity<FilmListResponseDto> getAllFilms() {
        return ResponseEntity.ok()
                             .body(new FilmListResponseDto(Collections.emptyList()));
    }
}