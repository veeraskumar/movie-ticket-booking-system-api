package com.rvk.movie_ticket_booking_system_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;
    private String name, address, city, landmark, phoneNumber, email;
    private Long createdAt, updatedAt;
    private String createdBy;

    @ManyToOne
    private TheaterOwner theaterOwner;
}
