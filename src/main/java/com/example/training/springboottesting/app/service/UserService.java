package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.UserRankDto;
import com.example.training.springboottesting.app.entity.User;
import com.example.training.springboottesting.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CreatedBy Harpal Singh at 12/15/21
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }


    public List<UserRankDto> findYoungestInOrder(){
        return userRepository.findYoungest();
    }



}
