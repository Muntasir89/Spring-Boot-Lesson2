package com.muntasir.hotel.booking.app.domain.dto.response;

import com.muntasir.hotel.booking.app.domain.entity.Amenity;
import lombok.Data;

@Data
public class AmenityResponse {
    private Long id;
    private String name;

    public AmenityResponse(Amenity amenity) {
        this.id = amenity.getId();
        this.name = amenity.getName();
    }
}