package com.muntasir.hotel.booking.app.domain.dto.response;

import com.muntasir.hotel.booking.app.domain.entity.Room;
import lombok.Data;

@Data
public class RoomResponse {
    private Long id;
    private String roomType;
    private String status;
    private int maxOccupancy;

    public RoomResponse(Room room) {
        this.id = room.getId();
        this.roomType = room.getRoomType().name();
        this.status = room.getStatus().name();
        this.maxOccupancy = room.getMaxOccupancy();
    }
}