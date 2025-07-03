package com.muntasir.hotel.booking.app.service.auth;

import com.muntasir.hotel.booking.app.domain.dto.request.LoginRequest;
import com.muntasir.hotel.booking.app.domain.dto.request.RegisterRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.AuthResponse;

public interface AuthService {
    
    AuthResponse register(RegisterRequest registerRequest);
    
    AuthResponse login(LoginRequest loginRequest);
    
    AuthResponse refreshToken(String refreshToken);
    
    void logout(String username);
    
    boolean validateToken(String token);
    
    String getUsernameFromToken(String token);
    
    Long getUserIdFromToken(String token);
    
    String getRoleFromToken(String token);
}