package com.muntasir.hotel.booking.app.domain.dto.request;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long bookingId;
    private double amount;
    private String paymentMethod;
}