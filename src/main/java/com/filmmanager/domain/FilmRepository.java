package com.filmmanager.domain;

import com.filmmanager.domain.model.Film;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface FilmRepository extends Repository<Film, Long> {


    void save(Film film);

    Film findByTitle(String title);

    Film delete(Film title);

    List<Film> findAll();
}