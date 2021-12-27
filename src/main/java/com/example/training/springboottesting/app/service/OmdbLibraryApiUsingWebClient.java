package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class OmdbLibraryApiUsingWebClient {


    private WebClient webClient;


    @Value("${movie.api.access.key}")
    private String apiKey;

    @Value("${movie.api.end.point}")
    private String movieApiEndPoint;


    OmdbLibraryApiUsingWebClient(@Value("${movie.api.end.point}") String baseUrl) {
        webClient = WebClient.create(baseUrl);
    }


    public MovieDTO fetchMovieDetailsByTitle(String title) throws Exception {
        MovieDTO result = webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("apiKey", apiKey)
                        .queryParam("type", "movie")
                        .queryParam("t", title)
                        .build())
                .retrieve()
                .bodyToMono(MovieDTO.class)
                .retryWhen(Retry.fixedDelay(2, Duration.ofMillis(200)))
                .block();
        return result;
    }


    public Mono<MovieDTO> subscribeMovieDetailsByTitle(String title) throws Exception {
        Mono<MovieDTO> movieDTOMono = webClient.get()
                .uri("?apiKey=" + apiKey + "&type=movie&t=" + title)
                .retrieve()
                .bodyToMono(MovieDTO.class)
                .retryWhen(Retry.fixedDelay(2, Duration.ofMillis(200)));
        return movieDTOMono;
    }
}

