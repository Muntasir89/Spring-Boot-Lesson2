package com.muntasir.hotel.booking.app.domain.dto.response;

import com.muntasir.hotel.booking.app.domain.entity.Hotel;
import lombok.Data;

@Data
public class HotelResponse {
    private Long id;
    private String name;
    private String address;
    private double rating;

    public HotelResponse(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.address = hotel.getAddress();
        this.rating = hotel.getRating();
    }
}