package com.muntasir.hotel.booking.app.controller.hotel;

import com.muntasir.hotel.booking.app.domain.dto.request.RoomSearchRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.ApiResponse;
import com.muntasir.hotel.booking.app.domain.dto.response.RoomResponse;
import com.muntasir.hotel.booking.app.service.hotel.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RoomResponse>> getRoomById(@PathVariable Long id) {
        RoomResponse roomResponse = roomService.getRoomById(id);
        return ResponseEntity.ok(ApiResponse.success(roomResponse, "Room retrieved successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RoomResponse>>> searchRooms(RoomSearchRequest request) {
        List<RoomResponse> rooms = roomService.searchRooms(request);
        return ResponseEntity.ok(ApiResponse.success(rooms, "Rooms retrieved successfully"));
    }
}