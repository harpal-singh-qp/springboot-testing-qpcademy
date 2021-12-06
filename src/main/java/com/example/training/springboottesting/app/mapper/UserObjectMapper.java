package com.example.training.springboottesting.app.mapper;

import com.example.training.springboottesting.app.dto.UserDTO;
import com.example.training.springboottesting.app.dto.UserRequest;
import com.example.training.springboottesting.app.entity.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * CreatedBy Harpal Singh at 12/5/21
 */
@Component
public class UserObjectMapper implements CustomObjectMapper {


    public User convertToUserObject(UserRequest userRequest) {
        return new User().setFirstName(userRequest.getFirstName())
                .setLastName(userRequest.getLastName())
                .setEmailAddress(userRequest.getEmailAddress())
                .setPhoneNumber(userRequest.getPhoneNumber())
                .setCreatedAt(new Date())
                .setUpdatedAt(new Date());
    }


    public UserDTO converToUserDTO(User user) {
        return UserDTO.builder().firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .userId(user.getId())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
