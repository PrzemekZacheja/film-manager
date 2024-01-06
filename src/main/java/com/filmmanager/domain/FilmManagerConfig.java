package com.filmmanager.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilmManagerConfig {

    @Bean
    public FilmFacade filmFacade() {
        return new FilmFacade();
    }
}