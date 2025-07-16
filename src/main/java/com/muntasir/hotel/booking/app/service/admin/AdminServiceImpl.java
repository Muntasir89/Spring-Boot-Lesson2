package com.muntasir.hotel.booking.app.service.admin;

import com.muntasir.hotel.booking.app.domain.entity.ManagerInvite;
import com.muntasir.hotel.booking.app.domain.enums.users_security.Role;
import com.muntasir.hotel.booking.app.repository.ManagerInviteRepository;
import com.muntasir.hotel.booking.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final ManagerInviteRepository managerInviteRepository;

    @Override
    public Object getDashboardStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalUsers", userRepository.count());
        stats.put("totalManagers", userRepository.countByRoleName(Role.HOTEL_MANAGER));
        stats.put("totalBookings", 100L); // Replace with actual booking count logic
        return stats;
    }

    @Override
    public String generateManagerInvite(String email) {
        String token = UUID.randomUUID().toString();

        ManagerInvite invite = ManagerInvite.builder()
                .email(email)
                .token(token)
                .expiresAt(LocalDateTime.now().plusDays(3))
                .used(false)
                .isEmailVerified(true).build();

        managerInviteRepository.save(invite);
        return token;
    }
}