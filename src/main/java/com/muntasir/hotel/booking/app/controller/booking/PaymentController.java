package com.muntasir.hotel.booking.app.controller.payment;

import com.muntasir.hotel.booking.app.domain.dto.request.PaymentRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.domain.dto.response.PaymentResponse;
import com.muntasir.hotel.booking.app.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponse<PaymentResponse>> processPayment(@RequestBody PaymentRequest request) {
        PaymentResponse paymentResponse = paymentService.processPayment(request);
        return ResponseEntity.ok(ApiResponse.success(paymentResponse, "Payment processed successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PaymentResponse>> getPaymentById(@PathVariable Long id) {
        PaymentResponse paymentResponse = paymentService.getPaymentById(id);
        return ResponseEntity.ok(ApiResponse.success(paymentResponse, "Payment retrieved successfully"));
    }
}