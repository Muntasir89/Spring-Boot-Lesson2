package com.muntasir.hotel.booking.app.controller.booking;

import com.muntasir.hotel.booking.app.domain.dto.request.BookingRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.domain.dto.response.BookingResponse;
import com.muntasir.hotel.booking.app.service.booking.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<ApiResponse<BookingResponse>> createBooking(@RequestBody BookingRequest request) {
        BookingResponse bookingResponse = bookingService.createBooking(request);
        return ResponseEntity.ok(ApiResponse.success(bookingResponse, "Booking created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookingResponse>> getBookingById(@PathVariable Long id) {
        BookingResponse bookingResponse = bookingService.getBookingById(id);
        return ResponseEntity.ok(ApiResponse.success(bookingResponse, "Booking retrieved successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BookingResponse>>> getAllBookings() {
        List<BookingResponse> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(ApiResponse.success(bookings, "Bookings retrieved successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok(ApiResponse.success("Booking canceled successfully", "Cancellation completed"));
    }
}