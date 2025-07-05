package com.muntasir.hotel.booking.app.repository;

import com.muntasir.hotel.booking.app.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}