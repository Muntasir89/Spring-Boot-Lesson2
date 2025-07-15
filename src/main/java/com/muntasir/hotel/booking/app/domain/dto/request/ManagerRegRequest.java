package com.muntasir.hotel.booking.app.domain.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ManagerRegRequest extends RegisterRequest{
    private String token;
}
