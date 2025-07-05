package com.muntasir.hotel.booking.app.domain.dto.response;

import com.muntasir.hotel.booking.app.domain.entity.Payment;
import com.muntasir.hotel.booking.app.domain.enums.PaymentStatus;
import lombok.Data;

@Data
public class PaymentResponse {
    private Long id;
    private Long bookingId;
    private double amount;
    private String paymentMethod;
    private PaymentStatus status;

    public PaymentResponse(Payment payment) {
        this.id = payment.getId();
        this.bookingId = payment.getBooking().getId();
        this.amount = payment.getAmount();
        this.paymentMethod = payment.getPaymentMethod();
        this.status = payment.getStatus();
    }
}