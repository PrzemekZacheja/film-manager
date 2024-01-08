package com.filmmanager.infrastructure.filmreceiver.controller.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Log4j2
public class FilmManagerErrorHandler {


    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public FilmErrorResponseDto handleFilmDuplicatedException(DuplicateKeyException e) {
        String message = " The Film is already marked as a favorite";
        log.warn(message);
        return new FilmErrorResponseDto(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FilmNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public FilmErrorResponseDto handleFilmNotFoundException(FilmNotFoundException e) {
        String message = "Film is not found";
        log.warn(message);
        return new FilmErrorResponseDto(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}