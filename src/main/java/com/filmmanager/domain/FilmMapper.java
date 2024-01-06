package com.filmmanager.domain;

import com.filmmanager.domain.dto.FilmResponseDto;
import com.filmmanager.domain.model.Film;

import java.util.List;

public class FilmMapper {
    public static Film maptoFilm(FilmResponseDto filmResponseDto) {
        return Film.builder()
                   .title(filmResponseDto.title())
                   .director(filmResponseDto.director())
                   .genre(filmResponseDto.genre())
                   .poster(filmResponseDto.poster())
                   .plot(filmResponseDto.plot())
                   .build();
    }

    public static FilmResponseDto mapToFilmResponseDto(Film film) {
        return FilmResponseDto.builder()
                              .title(film.getTitle())
                              .director(film.getDirector())
                              .genre(film.getGenre())
                              .plot(film.getPlot())
                              .poster(film.getPoster())
                              .build();
    }

    public static List<FilmResponseDto> mapToListFilmResponseDto(List<Film> films) {
        return films.stream()
                    .map(FilmMapper::mapToFilmResponseDto)
                    .toList();
    }
}