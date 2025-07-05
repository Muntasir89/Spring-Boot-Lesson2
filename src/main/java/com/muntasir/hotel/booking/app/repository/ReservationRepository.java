package com.muntasir.hotel.booking.app.repository;

import com.muntasir.hotel.booking.app.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}