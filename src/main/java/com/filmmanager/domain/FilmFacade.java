package com.filmmanager.domain;

import com.filmmanager.domain.dto.FilmResponseDto;
import com.filmmanager.domain.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class FilmFacade {

    @Autowired
    OmdbApi client;
    @Autowired
    FilmRepository repository;
    @Value("${feign-client.apikey}")
    String apikey;

    public FilmResponseDto fetchFilmByTitle(String title) {
        FilmResponseDto filmByTitle = client.getFilmByTitle(apikey, title);
        return filmByTitle;
    }

    public FilmResponseDto addFilmToFavourites(FilmResponseDto filmResponseDto) {
        Film film = FilmMapper.maptoFilm(filmResponseDto);
        repository.save(film);
        Film byTitle = repository.findByTitle(filmResponseDto.title());
        FilmResponseDto returnedFilmResponseDto = FilmMapper.mapToFilmResponseDto(byTitle);
        return returnedFilmResponseDto;
    }
}