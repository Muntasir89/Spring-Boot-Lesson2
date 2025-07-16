package com.muntasir.hotel.booking.app.domain.entity;

import com.muntasir.hotel.booking.app.domain.dto.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invite-manager")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ManagerInvite extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name="used", nullable = false)
    private Boolean used = false;

    @Column(name = "is_email_verified", nullable = false)
    private Boolean isEmailVerified = false;
}
