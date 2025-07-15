package com.muntasir.hotel.booking.app.service.auth;

import com.muntasir.hotel.booking.app.domain.dto.request.auth.LoginRequest;
import com.muntasir.hotel.booking.app.domain.dto.request.auth.ManagerRegRequest;
import com.muntasir.hotel.booking.app.domain.dto.request.auth.RegisterRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.AuthResponse;

public interface AuthService {
    
    String register(RegisterRequest registerRequest);
    String completeManagerRegistration(ManagerRegRequest request);

    AuthResponse login(LoginRequest loginRequest);

    AuthResponse refreshToken(String refreshToken);

    void logout(String username);

    boolean validateToken(String token);

    String getUsernameFromToken(String token);

    Long getUserIdFromToken(String token);

    String getRoleFromToken(String token);

}