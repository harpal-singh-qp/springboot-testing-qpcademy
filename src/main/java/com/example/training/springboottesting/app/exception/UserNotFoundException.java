package com.example.training.springboottesting.app.exception;

/**
 * CreatedBy Harpal Singh at 12/5/21
 */
public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String user_not_found_exception) {
        super(user_not_found_exception);
    }
}
