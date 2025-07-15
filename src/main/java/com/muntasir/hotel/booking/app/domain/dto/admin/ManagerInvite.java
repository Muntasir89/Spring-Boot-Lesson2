package com.muntasir.hotel.booking.app.domain.dto.admin;

import com.muntasir.hotel.booking.app.domain.dto.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "manager_invites")
@NoArgsConstructor
@AllArgsConstructor
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

//@Entity
//@Table(name = "users")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class User extends BaseEntity {
//
//    @Column(unique = true, nullable = false)
//    private String username;
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "phone_number")
//    private String phoneNumber;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role = Role.USER;
//
//    @Column(name = "is_active")
//    private Boolean isActive = true;
//
//    @Column(name = "is_email_verified")
//    private Boolean isEmailVerified = false;
//
//    @Column(name = "last_login")
//    private java.time.LocalDateTime lastLogin;
//}