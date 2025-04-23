package com.rvk.movie_ticket_booking_system_api.repository;

import com.rvk.movie_ticket_booking_system_api.entity.UserDetails;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
    boolean existsByEmail(String email);
}