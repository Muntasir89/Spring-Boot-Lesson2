package com.muntasir.hotel.booking.app.controller.hotel;

import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.domain.dto.response.AmenityResponse;
import com.muntasir.hotel.booking.app.service.hotel.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/amenities")
@RequiredArgsConstructor
public class AmenityController {

    private final AmenityService amenityService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AmenityResponse>>> getAllAmenities() {
        List<AmenityResponse> amenities = amenityService.getAllAmenities();
        return ResponseEntity.ok(ApiResponse.success(amenities, "Amenities retrieved successfully"));
    }
}