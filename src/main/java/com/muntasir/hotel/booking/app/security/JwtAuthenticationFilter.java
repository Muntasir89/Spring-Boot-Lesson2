package com.muntasir.hotel.booking.app.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muntasir.hotel.booking.app.domain.dto.response.ErrorResponse;
import com.muntasir.hotel.booking.app.service.auth.AuthService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter implements Filter {

    private final AuthService authService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    // Public endpoints that don't require authentication
    private static final List<String> PUBLIC_ENDPOINTS = Arrays.asList(
        "/api/v1/auth/register",
        "/api/v1/auth/login", 
        "/api/v1/auth/refresh-token",
        "/api/v1/auth/validate-token",
        "/actuator",
        "/swagger-ui",
        "/v3/api-docs"
    );
    
    // Admin only endpoints
    private static final List<String> ADMIN_ENDPOINTS = Arrays.asList(
        "/api/v1/admin",
        "/api/v1/users" // Restrict user management to admin
    );
    
    // Hotel manager endpoints
    private static final List<String> HOTEL_MANAGER_ENDPOINTS = Arrays.asList(
        "/api/v1/hotels"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String requestURI = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();
        
        log.debug("Processing request: {} {}", method, requestURI);
        
        try {
            // Skip authentication for public endpoints
            if (isPublicEndpoint(requestURI)) {
                log.debug("Public endpoint accessed: {}", requestURI);
                chain.doFilter(request, response);
                return;
            }
            
            // Extract and validate JWT token
            String authHeader = httpRequest.getHeader("Authorization");
            
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                log.warn("Missing or invalid Authorization header for: {}", requestURI);
                sendUnauthorizedResponse(httpResponse, "Authorization header missing or invalid");
                return;
            }
            
            String token = authHeader.substring(7);
            
            // Validate token
            if (!authService.validateToken(token)) {
                log.warn("Invalid or expired token for: {}", requestURI);
                sendUnauthorizedResponse(httpResponse, "Invalid or expired token");
                return;
            }
            
            // Extract user information from token
            String username = authService.getUsernameFromToken(token);
            Long userId = authService.getUserIdFromToken(token);
            String role = authService.getRoleFromToken(token);
            
            // Create authentication context
            AuthenticationContext authContext = AuthenticationContext.builder()
                    .username(username)
                    .userId(userId)
                    .role(role)
                    .authenticated(true)
                    .build();
            
            // Set authentication context
            SecurityContextHolder.setContext(authContext);
            
            // Check role-based access
            if (!hasRequiredPermission(requestURI, method, role)) {
                log.warn("Access denied for user {} with role {} to endpoint: {}", username, role, requestURI);
                sendForbiddenResponse(httpResponse, "Access denied. Insufficient permissions");
                return;
            }
            
            log.debug("Authentication successful for user: {} with role: {}", username, role);
            
            // Continue with the request
            chain.doFilter(request, response);
            
        } catch (Exception e) {
            log.error("Authentication error: ", e);
            sendUnauthorizedResponse(httpResponse, "Authentication failed");
        } finally {
            // Clear security context after request
            SecurityContextHolder.clearContext();
        }
    }
    
    private boolean isPublicEndpoint(String requestURI) {
        return PUBLIC_ENDPOINTS.stream()
                .anyMatch(endpoint -> requestURI.startsWith(endpoint));
    }
    
    private boolean hasRequiredPermission(String requestURI, String method, String userRole) {
        // Admin has access to everything
        if ("ADMIN".equals(userRole) || "SUPER_ADMIN".equals(userRole)) {
            return true;
        }
        
        // Check admin-only endpoints
        if (ADMIN_ENDPOINTS.stream().anyMatch(endpoint -> requestURI.startsWith(endpoint))) {
            return false; // Only admin can access
        }
        
        // Check hotel manager endpoints
        if (HOTEL_MANAGER_ENDPOINTS.stream().anyMatch(endpoint -> requestURI.startsWith(endpoint))) {
            return "HOTEL_MANAGER".equals(userRole) || "ADMIN".equals(userRole);
        }
        
        // Profile endpoint - users can access their own profile
        if (requestURI.equals("/api/v1/users/profile") && "GET".equals(method)) {
            return true; // Any authenticated user can access their profile
        }
        
        // Default: authenticated users can access
        return true;
    }
    
    private void sendUnauthorizedResponse(HttpServletResponse response, String message) 
            throws IOException {
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.UNAUTHORIZED.value())
                .error("Unauthorized")
                .message(message)
                .path("")
                .build();
        
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
    
    private void sendForbiddenResponse(HttpServletResponse response, String message) 
            throws IOException {
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.FORBIDDEN.value())
                .error("Forbidden")
                .message(message)
                .path("")
                .build();
        
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}