package com.muntasir.hotel.booking.app.service.booking;

import com.muntasir.hotel.booking.app.domain.dto.request.BookingRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.BookingResponse;
import com.muntasir.hotel.booking.app.domain.entity.Booking;
import com.muntasir.hotel.booking.app.domain.entity.Room;
import com.muntasir.hotel.booking.app.domain.enums.BookingStatus;
import com.muntasir.hotel.booking.app.repository.BookingRepository;
import com.muntasir.hotel.booking.app.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    @Override
    public BookingResponse createBooking(BookingRequest request) {
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (!room.getStatus().equals("AVAILABLE")) {
            throw new RuntimeException("Room is not available for booking");
        }

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setUserId(request.getUserId());
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setStatus(BookingStatus.PENDING);

        room.setStatus("RESERVED");
        roomRepository.save(room);

        booking = bookingRepository.save(booking);
        return new BookingResponse(booking);
    }

    @Override
    public BookingResponse getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return new BookingResponse(booking);
    }

    @Override
    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(BookingResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);

        Room room = booking.getRoom();
        room.setStatus("AVAILABLE");
        roomRepository.save(room);
    }
}