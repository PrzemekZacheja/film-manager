package com.filmmanager.domain;

import com.filmmanager.domain.model.Film;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface FilmRepository extends Repository<Film, Long> {


    Film save(Film film);

    List<Film> findAll();

    boolean existsByTitleIgnoreCase(String title);
}