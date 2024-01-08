package com.filmmanager.infrastructure.filmreceiver.controller.error;

import org.springframework.http.HttpStatus;

public record FilmErrorResponseDto(String message,
                                   HttpStatus httpStatus) {
}