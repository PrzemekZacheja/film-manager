package com.filmmanager.domain.dto;

public record FilmDto(String title,
                      String plot,
                      String genre,
                      String director,
                      String poster) {
}