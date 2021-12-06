package com.example.training.springboottesting.app.mockito;

import java.time.Instant;

/**
 * @author Harpal Singh 11/15/21
 */
public interface ReviewInfo {
    Long getId();

    Long getBookId();

    String getContent();

    Instant getCreatedAt();
}
