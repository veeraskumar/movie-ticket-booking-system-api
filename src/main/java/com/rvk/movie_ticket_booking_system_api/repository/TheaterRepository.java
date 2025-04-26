package com.rvk.movie_ticket_booking_system_api.repository;

import com.rvk.movie_ticket_booking_system_api.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, String> {

}
