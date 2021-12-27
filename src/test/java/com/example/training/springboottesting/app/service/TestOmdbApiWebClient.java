package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.MovieDTO;
import lombok.extern.slf4j.Slf4j;
import net.joshka.junit.json.params.JsonFileSource;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.json.JsonObject;
import java.io.IOException;

/**
 * CreatedBy Harpal Singh at 12/20/21
 */
@Slf4j
@ExtendWith(SpringExtension.class)
class TestOmdbApiWebClient {


    OmdbLibraryApiUsingWebClient cut;

    MockWebServer mockWebServer;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer= new MockWebServer();
        mockWebServer.start();
        cut= new OmdbLibraryApiUsingWebClient(mockWebServer.url("/").toString());

    }

    @AfterEach
    void cleanUp() throws IOException {
        mockWebServer.shutdown();
    }

    @ParameterizedTest
    @JsonFileSource(resources = "/response/movie-response.json")
    void testFetchMovieByTitle(JsonObject jsonObject) throws Exception {
        ///Arrange
        MockResponse mockResponse = new MockResponse();
        mockResponse.addHeader("Content-Type","application/json");
        mockResponse.setBody(jsonObject.toString());


        mockWebServer.enqueue(mockResponse);


        //Act
        MovieDTO actualResult = cut.fetchMovieDetailsByTitle("Harry Potter");
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        recordedRequest.getPath();
        //Assert
        Assertions.assertEquals("Harry Potter and the Deathly Hallows: Part 2",actualResult.getTitle());

    }

}


