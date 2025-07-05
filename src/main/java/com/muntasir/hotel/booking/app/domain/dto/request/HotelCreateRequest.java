package com.muntasir.hotel.booking.app.domain.dto.request;

import lombok.Data;

@Data
public class HotelCreateRequest {
    private String name;
    private String address;
    private double rating;
}