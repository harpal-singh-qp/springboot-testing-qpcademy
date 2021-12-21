package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;

@Component
public class OmdbLibraryApiClient {

    private final RestTemplate restTemplate;

    @Value("${movie.api.access.key}")
    private String apiKey;

    @Value("${movie.api.end.point}")
    private String movieApiEndPoint;


    public OmdbLibraryApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .rootUri(movieApiEndPoint)
                .setConnectTimeout(Duration.ofSeconds(2))
                .setReadTimeout(Duration.ofSeconds(2))
                .build();
    }

    public MovieDTO fetchMovieDetailsByTitle(String title) throws Exception {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<Void> entity = new HttpEntity<>(headers);
           try {
               MovieDTO movie = restTemplate.exchange("?apiKey=" + apiKey + "&type=movie&t=" + title,
                       HttpMethod.GET,
                       entity,
                       MovieDTO.class)
                       .getBody();
               return movie;
           }catch(Exception e){
               throw new Exception("OmdbAPI Server is Down");
           }

    }
}

