package com.filmmenager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class FilmController {

    @GetMapping("/film")
    public ResponseEntity<FilmSearchResponseDto> findFilm(String title) {
        return ResponseEntity.ok()
                             .body(new FilmSearchResponseDto());
    }

    @GetMapping("/film/fav")
    public ResponseEntity<FilmFavoriteResponseDto> setFavorite(String title) {
        return ResponseEntity.ok()
                             .body(new FilmFavoriteResponseDto());
    }

    @GetMapping("/films")
    public ResponseEntity< FilmListResponse> getAllFilms() {
        return ResponseEntity.ok()
                             .body(new FilmListResponse(Collections.emptyList()));
    }
}