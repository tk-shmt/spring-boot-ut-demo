package com.example.ut_demo.api.service;

import com.example.ut_demo.api.mapper.UserMapper;
import com.example.ut_demo.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(int id) {
        return userMapper.findById(id);
    }
}
