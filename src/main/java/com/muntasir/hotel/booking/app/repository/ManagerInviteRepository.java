package com.muntasir.hotel.booking.app.repository;

import com.muntasir.hotel.booking.app.domain.entity.ManagerInvite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerInviteRepository extends JpaRepository<ManagerInvite, Long> {
    Optional<ManagerInvite> findByToken(String token);

    Optional<ManagerInvite> findByEmailAndUsedFalse(String email);

    // Custom query methods can be defined here if needed
    // For example, to find an invite by email or token

    // List<ManagerInvite> findAllByUsedFalseAndExpiresAtAfter(LocalDateTime now);
}
