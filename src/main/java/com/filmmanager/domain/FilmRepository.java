package com.filmmanager.domain;

import com.filmmanager.domain.model.Film;
import org.springframework.data.repository.Repository;

public interface FilmRepository extends Repository<Film, Long> {
}