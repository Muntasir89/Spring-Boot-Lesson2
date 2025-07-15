package com.muntasir.hotel.booking.app.domain.dto.request;


import lombok.Data;

@Data
public class ManagerRegRequest {
    private String token;
    private String fullName;
    private String email;
}
