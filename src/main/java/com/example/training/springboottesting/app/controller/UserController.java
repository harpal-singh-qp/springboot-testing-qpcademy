package com.example.training.springboottesting.app.controller;

import com.example.training.springboottesting.app.dto.UserDTO;
import com.example.training.springboottesting.app.dto.UserRequest;
import com.example.training.springboottesting.app.entity.User;
import com.example.training.springboottesting.app.mapper.UserObjectMapper;
import com.example.training.springboottesting.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CreatedBy Harpal Singh at 12/2/21
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserObjectMapper userObjectMapper;

    @PostMapping(value = "create-user" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO createUser(@RequestBody UserRequest userRequest) {
        User user = userRepository.save(userObjectMapper.convertToUserObject(userRequest));
        return userObjectMapper.converToUserDTO(user);
    }

}
