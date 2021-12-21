package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.MovieDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
//import org.springframework.test.web.client.MockRestServiceServer;
//import org.springframework.test.web.client.match.MockRestRequestMatchers;
//import org.springframework.test.web.client.response.MockRestResponseCreators;

/**
 * CreatedBy Harpal Singh at 12/20/21
 */

@RestClientTest(OmdbLibraryApiClient.class)
public class TestOmdbApiRestClient {

    @Autowired
    OmdbLibraryApiClient cut;


    @Autowired
    MockRestServiceServer mockRestServiceServer;


    @Test
    void testSetUp() {
        Assertions.assertNotNull(mockRestServiceServer);
        Assertions.assertNotNull(cut);
    }
//Arrange Act Assert //
    @Test
    void testFetchMovieByTitle() throws Exception {

        this.mockRestServiceServer.expect(
                MockRestRequestMatchers
                        .requestTo(Matchers.containsString("&type=movie&t")))
                .andRespond(MockRestResponseCreators.withSuccess(new ClassPathResource("/response/movie-response.json"), MediaType.APPLICATION_JSON));
        MovieDTO actualResult = cut.fetchMovieDetailsByTitle("Harry Potter");

        Assertions.assertEquals("Harry Potter and the Deathly Hallows: Part 2".toUpperCase(),actualResult.getTitle());

    }

    @Test
    void testWhenRemoteAPiIsDown()  {

        this.mockRestServiceServer.expect(
                MockRestRequestMatchers
                        .requestTo(Matchers.containsString("&type=movie&t")))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.BAD_GATEWAY));
        Assertions.assertThrows(Exception.class, ()-> cut.fetchMovieDetailsByTitle("Harry Potter"),
                "OmdbAPI Server is Down");
    }

}

