package com.muntasir.hotel.booking.app.service.admin;

import com.muntasir.hotel.booking.app.repository.BookingRepository;
import com.muntasir.hotel.booking.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    @Override
    public Object getDashboardStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalUsers", userRepository.count());
        stats.put("totalBookings", bookingRepository.count());
        stats.put("totalRevenue", bookingRepository.calculateTotalRevenue()); // Example custom query
        return stats;
    }
}