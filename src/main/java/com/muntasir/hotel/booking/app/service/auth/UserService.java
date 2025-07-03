package com.muntasir.hotel.booking.app.service.auth;

import com.muntasir.hotel.booking.app.domain.dto.user.User;
import com.muntasir.hotel.booking.app.domain.dto.request.RegisterRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    User createUser(RegisterRequest registerRequest);
    
    Optional<User> findById(Long id);
    
    Optional<User> findByUsername(String username);
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByUsernameOrEmail(String usernameOrEmail);
    
    UserResponse getUserById(Long id);
    
    UserResponse getUserByUsername(String username);
    
    List<UserResponse> getAllUsers();
    
    User updateUser(Long id, User user);
    
    void deleteUser(Long id);
    
    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);
    
    void updateLastLogin(String username);
    
    boolean isUserActive(String username);
}