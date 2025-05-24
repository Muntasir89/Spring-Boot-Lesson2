package com.practice.firstproject.service;

import com.practice.firstproject.entity.User;
import com.practice.firstproject.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
}
