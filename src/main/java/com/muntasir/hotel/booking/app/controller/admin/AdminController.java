package com.muntasir.hotel.booking.app.controller.admin;

import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse<Object>> getDashboardStats() {
        Object stats = adminService.getDashboardStats();
        return ResponseEntity.ok(ApiResponse.success(stats, "Dashboard stats retrieved successfully"));
    }

    @PostMapping("/create-manager")
    public ResponseEntity<ApiResponse<String>> createManager(@RequestParam String email) {
        adminService.createManager(email);
        return ResponseEntity.ok(ApiResponse.success("Manager created successfully", "Operation successful"));
    }
}