package com.muntasir.hotel.booking.app.service.booking;

import com.muntasir.hotel.booking.app.domain.dto.request.ReservationRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ReservationResponse;
import com.muntasir.hotel.booking.app.domain.entity.Reservation;
import com.muntasir.hotel.booking.app.domain.entity.Room;
import com.muntasir.hotel.booking.app.domain.enums.BookingStatus;
import com.muntasir.hotel.booking.app.repository.ReservationRepository;
import com.muntasir.hotel.booking.app.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    @Override
    public ReservationResponse createReservation(ReservationRequest request) {
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (!room.getStatus().equals("AVAILABLE")) {
            throw new RuntimeException("Room is not available for reservation");
        }

        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setUserId(request.getUserId());
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        reservation.setStatus(BookingStatus.PENDING);

        room.setStatus("RESERVED");
        roomRepository.save(room);

        reservation = reservationRepository.save(reservation);
        return new ReservationResponse(reservation);
    }

    @Override
    public ReservationResponse getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return new ReservationResponse(reservation);
    }

    @Override
    public List<ReservationResponse> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setStatus(BookingStatus.CANCELLED);
        reservationRepository.save(reservation);

        Room room = reservation.getRoom();
        room.setStatus("AVAILABLE");
        roomRepository.save(room);
    }
}