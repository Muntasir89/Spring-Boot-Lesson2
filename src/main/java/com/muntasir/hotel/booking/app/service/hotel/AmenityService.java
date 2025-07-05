package com.muntasir.hotel.booking.app.service.hotel;

import com.muntasir.hotel.booking.app.domain.dto.response.AmenityResponse;

import java.util.List;

public interface AmenityService {
    List<AmenityResponse> getAllAmenities();
}