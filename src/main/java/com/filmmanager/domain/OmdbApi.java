package com.filmmanager.domain;

import com.filmmanager.domain.dto.FilmResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdb.api", url = "http://www.omdbapi.com/")
public interface OmdbApi {

    @GetMapping
    FilmResponseDto getFilmByTitle(@RequestParam String apikey, @RequestParam String t);

}

//TODO implementuj Pageable