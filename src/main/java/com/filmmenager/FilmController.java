package com.filmmenager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class FilmController {

    @GetMapping("/film/{title}")
    public ResponseEntity<FilmSearchResponseDto> getFilmByTitle(@PathVariable String title) {
        return ResponseEntity.ok()
                             .body(new FilmSearchResponseDto());
    }

    @GetMapping("/film/fav/{title}")
    public ResponseEntity<FilmFavoriteResponseDto> setFavorite(@PathVariable String title) {
        return ResponseEntity.ok()
                             .body(new FilmFavoriteResponseDto());
    }

    @GetMapping("/films")
    public ResponseEntity< FilmListResponse> getAllFilms() {
        return ResponseEntity.ok()
                             .body(new FilmListResponse(Collections.emptyList()));
    }
}