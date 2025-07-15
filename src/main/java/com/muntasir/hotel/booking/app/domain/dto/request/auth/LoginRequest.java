package com.muntasir.hotel.booking.app.domain.dto.request.auth;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String usernameOrEmail;
    private String password;
}
