package com.muntasir.hotel.booking.app.controller.booking;

import com.muntasir.hotel.booking.app.domain.dto.request.ReservationRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.domain.dto.response.ReservationResponse;
import com.muntasir.hotel.booking.app.service.booking.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ApiResponse<ReservationResponse>> createReservation(@RequestBody ReservationRequest request) {
        ReservationResponse reservationResponse = reservationService.createReservation(request);
        return ResponseEntity.ok(ApiResponse.success(reservationResponse, "Reservation created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReservationResponse>> getReservationById(@PathVariable Long id) {
        ReservationResponse reservationResponse = reservationService.getReservationById(id);
        return ResponseEntity.ok(ApiResponse.success(reservationResponse, "Reservation retrieved successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ReservationResponse>>> getAllReservations() {
        List<ReservationResponse> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(ApiResponse.success(reservations, "Reservations retrieved successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.ok(ApiResponse.success("Reservation canceled successfully", "Cancellation completed"));
    }
}