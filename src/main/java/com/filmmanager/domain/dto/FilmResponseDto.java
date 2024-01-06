package com.filmmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record FilmResponseDto(@JsonProperty("Title")
                              String title,
                              @JsonProperty("Plot")
                              String plot,
                              @JsonProperty("Genre")
                              String genre,
                              @JsonProperty("Director")
                              String director,
                              @JsonProperty("Poster")
                              String poster) {
}