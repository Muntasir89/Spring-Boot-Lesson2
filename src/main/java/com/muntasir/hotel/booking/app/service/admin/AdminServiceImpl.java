package com.muntasir.hotel.booking.app.service.admin;

import com.muntasir.hotel.booking.app.domain.entity.user.Role;
import com.muntasir.hotel.booking.app.domain.entity.user.User;
import com.muntasir.hotel.booking.app.repository.user.RoleRepository;
import com.muntasir.hotel.booking.app.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public Object getDashboardStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalUsers", userRepository.count());
        stats.put("totalManagers", userRepository.countByRoleName("MANAGER"));
        stats.put("totalBookings", 100L); // Replace with actual booking count logic
        return stats;
    }

    @Override
    public void createManager(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role managerRole = roleRepository.findByName("MANAGER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.getRoles().add(managerRole);
        userRepository.save(user);
    }
}