package com.muntasir.hotel.booking.app.controller.admin;

import com.muntasir.hotel.booking.app.domain.dto.request.admin.InviteRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @PostMapping("/invite-manager")
    public ResponseEntity<ApiResponse<String>> inviteManager(@RequestBody InviteRequest inviteRequest) {

        try {
            log.info("Invite manager request received for email: {}", inviteRequest.getEmail());
            String token = adminService.generateManagerInvite(inviteRequest.getEmail());
            return ResponseEntity.ok(ApiResponse.success(token, "Share this token with the manager"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }
}