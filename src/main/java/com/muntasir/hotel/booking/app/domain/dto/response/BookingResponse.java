package com.muntasir.hotel.booking.app.domain.dto.response;

import com.muntasir.hotel.booking.app.domain.entity.Booking;
import com.muntasir.hotel.booking.app.domain.enums.BookingStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingResponse {
    private Long id;
    private Long userId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BookingStatus status;

    public BookingResponse(Booking booking) {
        this.id = booking.getId();
        this.userId = booking.getUserId();
        this.roomId = booking.getRoom().getId();
        this.checkInDate = booking.getCheckInDate();
        this.checkOutDate = booking.getCheckOutDate();
        this.status = booking.getStatus();
    }
}