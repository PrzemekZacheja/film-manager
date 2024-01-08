package com.filmmanager.infrastructure.filmreceiver.controller;

import com.filmmanager.domain.FilmFacade;
import com.filmmanager.domain.dto.FilmResponseDto;
import com.filmmanager.infrastructure.filmreceiver.controller.error.FilmNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
public class FilmController {

    FilmFacade filmFacade;

    @GetMapping("/film/{title}")
    public ResponseEntity<FilmResponseDto> getFilmByTitle(@PathVariable String title, @RequestHeader(required = false) boolean favorite) {
        FilmResponseDto filmResponseDto = filmFacade.fetchFilmByTitle(title);
        log.info("Fetched film from foreign Api: " + filmResponseDto);

        if (filmResponseDto.title() != null) {
            log.info("Returned film: " + filmResponseDto);
            if (favorite) {
                filmFacade.addFilmToFavourites(filmResponseDto);
                log.info("Added film to favourites");
            } else {
                log.info("Film is not marked as favourite: " + filmResponseDto);
            }
            return ResponseEntity.ok()
                                 .body(filmResponseDto);
        } else {
            log.warn("Film not found: " + title);
            throw new FilmNotFoundException("Film is not found");
        }
    }

    @GetMapping("/films")
    public ResponseEntity<List<FilmResponseDto>> getAllFavouriteFilms() {
        List<FilmResponseDto> filmResponseDtos = filmFacade.fetchAllFavouriteFilms();
        log.info("Fetched favourite films: " + filmResponseDtos.size());
        return ResponseEntity.ok()
                             .body(filmResponseDtos);
    }
}