package com.filmmanager.domain;

import com.filmmanager.domain.dto.FilmResponseDto;
import com.filmmanager.domain.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public class FilmFacade {

    @Autowired
    OmdbApi client;
    @Autowired
    FilmRepository repository;
    @Value("${feign-client.apikey}")
    String apikey;

    public FilmResponseDto fetchFilmByTitle(String title) {
        return client.getFilmByTitle(apikey, title);
    }

    public void addFilmToFavourites(FilmResponseDto filmResponseDto) {
        Film film = FilmMapper.maptoFilm(filmResponseDto);
        if (repository.existsByTitleIgnoreCase(film.getTitle())) {
            throw new DuplicateKeyException("Film with title: " + film.getTitle() + " already exists");
        } else {
            repository.save(film);
        }
    }

    public List<FilmResponseDto> fetchAllFavouriteFilms() {
        return FilmMapper.mapToListFilmResponseDto(repository.findAll());
    }
}