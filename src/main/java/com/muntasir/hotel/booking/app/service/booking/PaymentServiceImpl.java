package com.muntasir.hotel.booking.app.service.booking;

import com.muntasir.hotel.booking.app.domain.dto.request.PaymentRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.PaymentResponse;
import com.muntasir.hotel.booking.app.domain.entity.Booking;
import com.muntasir.hotel.booking.app.domain.entity.Payment;
import com.muntasir.hotel.booking.app.domain.enums.booking.PaymentStatus;
import com.muntasir.hotel.booking.app.service.payment.PaymentService;
import com.muntasir.hotel.booking.app.repository.BookingRepository;
import com.muntasir.hotel.booking.app.repository.PaymentRepository;
import com.muntasir.hotel.booking.app.domain.enums.booking.BookingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatus(PaymentStatus.SUCCESS);

        booking.setStatus(BookingStatus.CONFIRMED);
        bookingRepository.save(booking);

        payment = paymentRepository.save(payment);
        return new PaymentResponse(payment);
    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return new PaymentResponse(payment);
    }
}