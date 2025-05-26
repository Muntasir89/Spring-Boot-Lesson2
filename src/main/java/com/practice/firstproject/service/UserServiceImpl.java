package com.practice.firstproject.service;

import com.practice.firstproject.entity.User;
import com.practice.firstproject.model.UserModel;
import com.practice.firstproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel){
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(userModel.getPassword());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return user;
    }
}
