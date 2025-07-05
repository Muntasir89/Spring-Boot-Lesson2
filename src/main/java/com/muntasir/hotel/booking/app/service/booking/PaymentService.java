package com.muntasir.hotel.booking.app.service.payment;

import com.muntasir.hotel.booking.app.domain.dto.request.PaymentRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
    PaymentResponse getPaymentById(Long id);
}