package com.example.training.springboottesting.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * CreatedBy Harpal Singh at 12/5/21
 */
@Builder
@Data
@ToString
public class UserDTO {
    private long userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
}
