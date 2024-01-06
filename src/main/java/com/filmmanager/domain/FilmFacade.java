package com.filmmanager.domain;

import com.filmmanager.domain.dto.FilmResponseDto;
import com.filmmanager.domain.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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
        repository.save(film);
        Film byTitle = repository.findByTitle(filmResponseDto.title());
        FilmMapper.mapToFilmResponseDto(byTitle);
    }

    public boolean isFavourite(FilmResponseDto filmResponseDto) {
        Film byTitle = repository.findByTitle(filmResponseDto.title());
        return byTitle != null;
    }

    public void removeFilmFromFavourites(FilmResponseDto filmResponseDto) {
        Film byTitle = repository.findByTitle(filmResponseDto.title());
        Film delete = repository.delete(byTitle);
        FilmMapper.mapToFilmResponseDto(byTitle);
    }

    public List<FilmResponseDto> fetchAllFavouriteFilms() {
        return FilmMapper.mapToListFilmResponseDto(repository.findAll());
    }
}