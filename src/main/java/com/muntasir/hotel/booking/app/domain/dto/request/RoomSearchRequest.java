package com.muntasir.hotel.booking.app.domain.dto.request;

import lombok.Data;

@Data
public class RoomSearchRequest {
    private String roomType;
    private String status;
    private int maxOccupancy;
}