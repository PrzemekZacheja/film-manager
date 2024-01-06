package com.filmmanager.domain;

import com.filmmanager.domain.dto.FilmResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class FilmFacade {

    @Autowired
    OmdbApi client;
    @Value("${feign-client.apikey}")
    String apikey;

    public FilmResponseDto fetchFilmByTitle(String title) {
        FilmResponseDto filmByTitle = client.getFilmByTitle(apikey, title);
        return filmByTitle;
    }

    public FilmResponseDto addFilmToFavourites(FilmResponseDto filmResponseDto) {
        return null;
    }
}