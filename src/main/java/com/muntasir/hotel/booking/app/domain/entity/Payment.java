package com.muntasir.hotel.booking.app.domain.entity;

import com.muntasir.hotel.booking.app.domain.enums.booking.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    private double amount;
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}