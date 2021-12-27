package com.example.training.springboottesting.app.controller;

import com.example.training.springboottesting.app.dto.UserDTO;
import com.example.training.springboottesting.app.dto.UserRequest;
import com.example.training.springboottesting.app.entity.User;
import com.example.training.springboottesting.app.mapper.UserObjectMapper;
import com.example.training.springboottesting.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @GetMapping(value = "get-user" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUserByUserID(@RequestParam("user-id") long userID) {
        User user = userRepository.findById(userID).get();
        return userObjectMapper.converToUserDTO(user);
    }


    @GetMapping(value = "get-user-by-email" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getUserByEmailAddress(@RequestParam("email-address") String emailAddress) {
        List<User> user = userRepository.findByEmailAddress(emailAddress);
        List<UserDTO> userDTOList = new ArrayList<>();
        user.stream().forEach(u-> addUserDto(u, userDTOList));
        return userDTOList;
    }

    private void addUserDto(User u, List<UserDTO> userDTOList) {
        userDTOList.add(userObjectMapper.converToUserDTO(u));
    }

}
