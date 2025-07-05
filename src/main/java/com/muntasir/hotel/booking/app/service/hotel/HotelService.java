package com.muntasir.hotel.booking.app.service.hotel;

import com.muntasir.hotel.booking.app.domain.dto.request.HotelCreateRequest;
import com.muntasir.hotel.booking.app.domain.dto.response.HotelResponse;

import java.util.List;

public interface HotelService {
    HotelResponse createHotel(HotelCreateRequest request);
    HotelResponse getHotelById(Long id);
    List<HotelResponse> getAllHotels();
    void deleteHotel(Long id);
}