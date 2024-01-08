package com.filmmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FilmManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmManagerApplication.class, args);
    }

}

//TODO napisz readme.txt