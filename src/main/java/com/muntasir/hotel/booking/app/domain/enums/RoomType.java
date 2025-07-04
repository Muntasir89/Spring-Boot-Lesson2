package com.muntasir.hotel.booking.app.domain.enums;

public enum RoomType {
    SINGLE("Single Room", 1),
    DOUBLE("Double Room", 2),
    TWIN("Twin Room", 2),
    TRIPLE("Triple Room", 3),
    QUAD("Quad Room", 4),
    KING("King Room", 2),
    QUEEN("Queen Room", 2),
    SUITE("Suite", 4),
    DELUXE("Deluxe Room", 2),
    EXECUTIVE("Executive Room", 2),
    PRESIDENTIAL("Presidential Suite", 6),
    FAMILY("Family Room", 6),
    STUDIO("Studio Apartment", 2),
    PENTHOUSE("Penthouse", 8);

    private final String displayName;
    private final int maxOccupancy;

    RoomType(String displayName, int maxOccupancy) {
        this.displayName = displayName;
        this.maxOccupancy = maxOccupancy;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }
}

