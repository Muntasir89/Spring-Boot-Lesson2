package com.muntasir.hotel.booking.app.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationContext {
    private String username;
    private Long userId;
    private String role;
    private boolean authenticated;
    
    public boolean hasRole(String role) {
        return this.role != null && this.role.equalsIgnoreCase(role);
    }
    
    public boolean hasAnyRole(String... roles) {
        if (this.role == null) return false;
        for (String role : roles) {
            if (this.role.equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }
}