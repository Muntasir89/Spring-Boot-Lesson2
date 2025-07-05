package com.muntasir.hotel.booking.app.service.hotel;

import com.muntasir.hotel.booking.app.domain.dto.response.AmenityResponse;
import com.muntasir.hotel.booking.app.domain.entity.Amenity;
import com.muntasir.hotel.booking.app.repository.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    private final AmenityRepository amenityRepository;

    @Override
    public List<AmenityResponse> getAllAmenities() {
        return amenityRepository.findAll().stream()
                .map(AmenityResponse::new)
                .collect(Collectors.toList());
    }
}