package com.muntasir.hotel.booking.app.controller.auth;

import com.muntasir.hotel.booking.app.domain.dto.request.LoginRequest;
import com.muntasir.hotel.booking.app.domain.dto.request.RegisterRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.domain.dto.response.AuthResponse;
import com.muntasir.hotel.booking.app.service.auth.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(
            @RequestBody RegisterRequest registerRequest) {
        
        log.info("Registration request received for username: {}", registerRequest.getUsername());
        
        AuthResponse authResponse = authService.register(registerRequest);
        
        ApiResponse<AuthResponse> response = ApiResponse.success(
            authResponse, 
            "User registered successfully"
        );
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(
            @RequestBody LoginRequest loginRequest) {
        
        log.info("Login request received for: {}", loginRequest.getUsernameOrEmail());
        
        AuthResponse authResponse = authService.login(loginRequest);
        
        ApiResponse<AuthResponse> response = ApiResponse.success(
            authResponse, 
            "Login successful"
        );
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponse<AuthResponse>> refreshToken(
            @RequestBody Map<String, String> request) {
        
        String refreshToken = request.get("refreshToken");
        log.info("Token refresh request received");
        
        AuthResponse authResponse = authService.refreshToken(refreshToken);
        
        ApiResponse<AuthResponse> response = ApiResponse.success(
            authResponse, 
            "Token refreshed successfully"
        );
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(HttpServletRequest request) {
        
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String username = authService.getUsernameFromToken(token);
            authService.logout(username);
            log.info("User logged out: {}", username);
        }
        
        ApiResponse<String> response = ApiResponse.success(
            "Logged out successfully", 
            "Logout successful"
        );
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/validate-token")
    public ResponseEntity<ApiResponse<Map<String, Object>>> validateToken(
            HttpServletRequest request) {
        
        String authHeader = request.getHeader("Authorization");
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            ApiResponse<Map<String, Object>> response = ApiResponse.error(
                "Authorization header missing or invalid", 
                HttpStatus.UNAUTHORIZED.value()
            );
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
        
        String token = authHeader.substring(7);
        boolean isValid = authService.validateToken(token);
        
        if (!isValid) {
            ApiResponse<Map<String, Object>> response = ApiResponse.error(
                "Invalid or expired token", 
                HttpStatus.UNAUTHORIZED.value()
            );
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
        
        // Extract token information
        String username = authService.getUsernameFromToken(token);
        Long userId = authService.getUserIdFromToken(token);
        String role = authService.getRoleFromToken(token);
        
        Map<String, Object> tokenInfo = Map.of(
            "valid", true,
            "username", username,
            "userId", userId,
            "role", role
        );
        
        ApiResponse<Map<String, Object>> response = ApiResponse.success(
            tokenInfo, 
            "Token is valid"
        );
        
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/complete-registration")
//    public ResponseEntity<ApiResponse<String>> completeRegistration(){
//        authService.completeManagerRegistration(request);
//        return ResponseEntity.ok(
//            ApiResponse.success("Registration completed successfully", "Registration successful")
//        );
//    }
}