package com.example.training.springboottesting.app.dto;

import lombok.Builder;
import lombok.Data;

/**
 * CreatedBy Harpal Singh at 12/14/21
 */
@Data
@Builder
public class UserRankDto {

    String firstName;
    String rank;
    String age;
}
