package com.filmmanager.infrastructure.filmreceiver.controller.error;

public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException(String message) {
        super(message);
    }
}