package com.practice.firstproject.service;

import com.practice.firstproject.entity.User;
import com.practice.firstproject.model.UserModel;
import org.springframework.stereotype.Service;


public interface UserService {
    public User registerUser(UserModel userModel);
}
