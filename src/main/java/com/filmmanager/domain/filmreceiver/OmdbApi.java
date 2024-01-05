package com.filmmanager.domain.filmreceiver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdb.api", url = "http://www.omdbapi.com/")
public interface OmdbApi {

    @GetMapping
    String getFilmByTitle(@RequestParam String t, @RequestParam(value = "${feignclient.apikey}") String apikey);

}