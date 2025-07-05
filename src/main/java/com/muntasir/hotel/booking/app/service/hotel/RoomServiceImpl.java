package com.muntasir.hotel.booking.app.service.hotel;

import com.muntasir.hotel.booking.app.domain.dto.request.RoomSearchRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.RoomResponse;
import com.muntasir.hotel.booking.app.domain.entity.Room;
import com.muntasir.hotel.booking.app.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomResponse getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        return new RoomResponse(room);
    }

    @Override
    public List<RoomResponse> searchRooms(RoomSearchRequest request) {
        // Implement search logic based on request criteria
        return roomRepository.findAll().stream()
                .map(RoomResponse::new)
                .collect(Collectors.toList());
    }
}
