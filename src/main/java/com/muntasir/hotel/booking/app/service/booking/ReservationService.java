package com.muntasir.hotel.booking.app.service.booking;

import com.muntasir.hotel.booking.app.domain.dto.request.ReservationRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ReservationResponse;

import java.util.List;

public interface ReservationService {
    ReservationResponse createReservation(ReservationRequest request);
    ReservationResponse getReservationById(Long id);
    List<ReservationResponse> getAllReservations();
    void cancelReservation(Long id);
}