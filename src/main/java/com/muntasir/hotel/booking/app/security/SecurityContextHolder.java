package com.muntasir.hotel.booking.app.security;

public class SecurityContextHolder {
    
    private static final ThreadLocal<AuthenticationContext> contextHolder = new ThreadLocal<>();
    
    public static void setContext(AuthenticationContext context) {
        contextHolder.set(context);
    }
    
    public static AuthenticationContext getContext() {
        return contextHolder.get();
    }
    
    public static void clearContext() {
        contextHolder.remove();
    }
    
    public static boolean isAuthenticated() {
        AuthenticationContext context = getContext();
        return context != null && context.isAuthenticated();
    }
    
    public static String getCurrentUsername() {
        AuthenticationContext context = getContext();
        return context != null ? context.getUsername() : null;
    }
    
    public static Long getCurrentUserId() {
        AuthenticationContext context = getContext();
        return context != null ? context.getUserId() : null;
    }
    
    public static String getCurrentUserRole() {
        AuthenticationContext context = getContext();
        return context != null ? context.getRole() : null;
    }
}