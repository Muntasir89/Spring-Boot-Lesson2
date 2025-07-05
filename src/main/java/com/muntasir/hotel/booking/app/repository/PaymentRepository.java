package com.muntasir.hotel.booking.app.repository;

import com.muntasir.hotel.booking.app.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}