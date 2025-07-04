package com.muntasir.hotel.booking.app.domain.enums.users_security;

public enum Role {
    USER("User"),
    ADMIN("Administrator"),
    HOTEL_MANAGER("Hotel Manager"),
    SUPER_ADMIN("Super Administrator");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}