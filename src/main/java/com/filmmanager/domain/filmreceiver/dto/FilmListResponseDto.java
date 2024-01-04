package com.filmmanager.domain.filmreceiver.dto;

import com.filmmanager.domain.filmreceiver.Film;

import java.util.List;

public record FilmListResponseDto(List<Film> films) {

}