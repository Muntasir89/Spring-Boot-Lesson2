package com.muntasir.hotel.booking.app.service.hotel;

import com.muntasir.hotel.booking.app.domain.dto.request.RoomSearchRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.RoomResponse;

import java.util.List;

public interface RoomService {
    RoomResponse getRoomById(Long id);
    List<RoomResponse> searchRooms(RoomSearchRequest request);
}