package com.muntasir.hotel.booking.app.controller.auth;

import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.domain.dto.response.UserResponse;
import com.muntasir.hotel.booking.app.security.SecurityContextHolder;
import com.muntasir.hotel.booking.app.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<ApiResponse<UserResponse>> getCurrentUserProfile() {
        
        String username = SecurityContextHolder.getCurrentUsername();
        log.info("Profile request for user: {}", username);
        
        UserResponse userResponse = userService.getUserByUsername(username);
        
        ApiResponse<UserResponse> response = ApiResponse.success(
            userResponse, 
            "Profile retrieved successfully"
        );
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
        
        log.info("Get user request for ID: {}", id);
        
        UserResponse userResponse = userService.getUserById(id);
        
        ApiResponse<UserResponse> response = ApiResponse.success(
            userResponse, 
            "User retrieved successfully"
        );
        
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
        
        log.info("Get all users request received");
        
        List<UserResponse> users = userService.getAllUsers();
        
        ApiResponse<List<UserResponse>> response = ApiResponse.success(
            users, 
            "Users retrieved successfully"
        );
        
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        
        log.info("Delete user request for ID: {}", id);
        
        userService.deleteUser(id);
        
        ApiResponse<String> response = ApiResponse.success(
            "User deleted successfully", 
            "Delete operation completed"
        );
        
        return ResponseEntity.ok(response);
    }
}