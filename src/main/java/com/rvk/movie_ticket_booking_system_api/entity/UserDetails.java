package com.rvk.movie_ticket_booking_system_api.entity;

import com.rvk.movie_ticket_booking_system_api.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userid;
    private String userName;
    @Column(unique = true)
    private String email;
    @Column(length = 10)
    private String phoneNumber;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role userRole;
    private LocalDate dataOfBirth;
    private long createAt;
    private long updateAt;
}
