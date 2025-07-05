package com.muntasir.hotel.booking.app.service.booking;

import com.muntasir.hotel.booking.app.domain.dto.request.BookingRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse createBooking(BookingRequest request);
    BookingResponse getBookingById(Long id);
    List<BookingResponse> getAllBookings();
    void cancelBooking(Long id);
}