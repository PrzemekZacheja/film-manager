package com.filmmanager.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    String title;
    String genre;
    String plot;
    String director;
    String poster;

    public Film() {
    }

    public Film(String title, String genre, String plot, String director, String poster) {
        this.title = title;
        this.genre = genre;
        this.plot = plot;
        this.director = director;
        this.poster = poster;
    }
}