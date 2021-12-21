package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CreatedBy Harpal Singh at 12/19/21
 */

@Service
public class EntertainmentQuestionHelperService {

    @Autowired
    OmdbLibraryApiClient apiClient;

    public MovieDTO fetchMovieDetailsByTitle(String title) throws Exception {
        return apiClient.fetchMovieDetailsByTitle(title);
    }
}
