package com.muntasir.hotel.booking.app.controller.hotel;

import com.muntasir.hotel.booking.app.domain.dto.request.HotelCreateRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.domain.dto.response.HotelResponse;
import com.muntasir.hotel.booking.app.service.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<HotelResponse>> createHotel(@RequestBody HotelCreateRequest request) {
        HotelResponse hotelResponse = hotelService.createHotel(request);
        return ResponseEntity.ok(ApiResponse.success(hotelResponse, "Hotel created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<HotelResponse>> getHotelById(@PathVariable Long id) {
        HotelResponse hotelResponse = hotelService.getHotelById(id);
        return ResponseEntity.ok(ApiResponse.success(hotelResponse, "Hotel retrieved successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<HotelResponse>>> getAllHotels() {
        List<HotelResponse> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(ApiResponse.success(hotels, "Hotels retrieved successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok(ApiResponse.success("Hotel deleted successfully", "Delete operation completed"));
    }
}