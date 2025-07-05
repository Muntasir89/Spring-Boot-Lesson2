package com.muntasir.hotel.booking.app.domain.entity;

import com.muntasir.hotel.booking.app.domain.enums.RoomType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private String status;
    private int maxOccupancy;
}