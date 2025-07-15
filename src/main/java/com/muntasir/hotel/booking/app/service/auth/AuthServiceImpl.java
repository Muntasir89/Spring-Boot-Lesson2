package com.muntasir.hotel.booking.app.service.auth;

import com.muntasir.hotel.booking.app.domain.dto.admin.ManagerInvite;
import com.muntasir.hotel.booking.app.domain.dto.request.ManagerRegRequest;
import com.muntasir.hotel.booking.app.domain.dto.user.User;
import com.muntasir.hotel.booking.app.domain.dto.request.LoginRequest;
import com.muntasir.hotel.booking.app.domain.dto.request.RegisterRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.AuthResponse;
import com.muntasir.hotel.booking.app.exception.AuthenticationException;
import com.muntasir.hotel.booking.app.exception.ValidationException;
import com.muntasir.hotel.booking.app.repository.ManagerInviteRepository;
import com.muntasir.hotel.booking.app.utils.JwtUtil;
import com.muntasir.hotel.booking.app.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {
    
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordUtil passwordUtil;
    private final ManagerInviteRepository managerInviteRepository;
    
    @Override
    public String register(RegisterRequest registerRequest) {
        log.info("Registering new user: {}", registerRequest.getUsername());
        
        try {
            // Create user
            User user = userService.createUser(registerRequest);
            
            log.info("User registered successfully: {}", user.getUsername());
            
            return "User registered successfully";
                    
        } catch (ValidationException e) {
            log.error("Registration validation failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Registration failed for user: {}", registerRequest.getUsername(), e);
            throw new AuthenticationException("Registration failed: " + e.getMessage());
        }
    }

    @Override
    public String completeManagerRegistration(ManagerRegRequest request) {
        ManagerInvite invite = managerInviteRepository.findByToken(request.getToken()).orElseThrow(() -> new RuntimeException("Invalid token"));

        if(invite.isUsed()){
            throw new RuntimeException("This invite has already been used");
        }

        if(invite.getExpiresAt().isBefore(LocalDateTime.now())){
            throw new RuntimeException("This invite has expired");
        }

        RegisterRequest registerRequest = RegisterRequest.builder()
                .username(request.getUsername())
                .email(invite.getEmail())
                .confirmPassword(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        String responseMessage = register(registerRequest);

        invite.setUsed(true);
        managerInviteRepository.save(invite);

        return responseMessage;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        log.info("Login attempt for: {}", loginRequest.getUsernameOrEmail());

        try {
            // Find user
            User user = userService.findByUsernameOrEmail(loginRequest.getUsernameOrEmail())
                    .orElseThrow(() -> new AuthenticationException("Invalid username/email or password"));

            // Check if user is active
            if (!user.getIsActive()) {
                throw new AuthenticationException("Account is deactivated");
            }

            // Verify password
            if (!passwordUtil.verifyPassword(loginRequest.getPassword(), user.getPassword())) {
                throw new AuthenticationException("Invalid username/email or password");
            }

            // Update last login
            userService.updateLastLogin(user.getUsername());

            // Generate tokens
            String accessToken = jwtUtil.generateToken(
                user.getUsername(),
                user.getId(),
                user.getRole().name()
            );
            String refreshToken = jwtUtil.generateRefreshToken(user.getUsername());

            // Calculate expiration
            Date expirationDate = jwtUtil.getExpirationDateFromToken(accessToken);
            LocalDateTime expiresAt = expirationDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            log.info("Login successful for user: {}", user.getUsername());

            return AuthResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .tokenType("Bearer")
                    .userId(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .role(user.getRole().name())
                    .expiresAt(expiresAt)
                    .message("Login successful")
                    .build();

        } catch (AuthenticationException e) {
            log.error("Login failed for: {}", loginRequest.getUsernameOrEmail());
            throw e;
        } catch (Exception e) {
            log.error("Login error for: {}", loginRequest.getUsernameOrEmail(), e);
            throw new AuthenticationException("Login failed: " + e.getMessage());
        }
    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {
        log.info("Refreshing token");

        try {
            if (!jwtUtil.validateToken(refreshToken)) {
                throw new AuthenticationException("Invalid refresh token");
            }

            String username = jwtUtil.getUsernameFromToken(refreshToken);
            User user = userService.findByUsername(username)
                    .orElseThrow(() -> new AuthenticationException("User not found"));

            if (!user.getIsActive()) {
                throw new AuthenticationException("Account is deactivated");
            }

            // Generate new tokens
            String newAccessToken = jwtUtil.generateToken(
                user.getUsername(),
                user.getId(),
                user.getRole().name()
            );
            String newRefreshToken = jwtUtil.generateRefreshToken(user.getUsername());

            // Calculate expiration
            Date expirationDate = jwtUtil.getExpirationDateFromToken(newAccessToken);
            LocalDateTime expiresAt = expirationDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            log.info("Token refreshed successfully for user: {}", username);

            return AuthResponse.builder()
                    .accessToken(newAccessToken)
                    .refreshToken(newRefreshToken)
                    .tokenType("Bearer")
                    .userId(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .role(user.getRole().name())
                    .expiresAt(expiresAt)
                    .message("Token refreshed successfully")
                    .build();

        } catch (Exception e) {
            log.error("Token refresh failed", e);
            throw new AuthenticationException("Token refresh failed: " + e.getMessage());
        }
    }

    @Override
    public void logout(String username) {
        log.info("Logout for user: {}", username);
        // In a real application, you might want to:
        // 1. Add token to blacklist
        // 2. Clear user sessions
        // 3. Log the logout event
        // For now, we just log it
    }

    @Override
    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }

    @Override
    public String getUsernameFromToken(String token) {
        return jwtUtil.getUsernameFromToken(token);
    }

    @Override
    public Long getUserIdFromToken(String token) {
        return jwtUtil.getUserIdFromToken(token);
    }

    @Override
    public String getRoleFromToken(String token) {
        return jwtUtil.getRoleFromToken(token);
    }

}