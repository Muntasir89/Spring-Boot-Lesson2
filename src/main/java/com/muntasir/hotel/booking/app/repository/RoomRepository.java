package com.muntasir.hotel.booking.app.repository;

import com.muntasir.hotel.booking.app.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}