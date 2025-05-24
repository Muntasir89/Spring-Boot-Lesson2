package com.practice.firstproject.service;

@Service
public class UserRepositoryImpl implements UserService {
    @Autowired
    private UserService userService;


    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(userModel.getPassword());
        return null;
    }
}
