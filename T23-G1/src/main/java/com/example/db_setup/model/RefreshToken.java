package com.example.db_setup.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "refresh_tokens", schema = "studentsrepo")
public class RefreshToken {
    @Id
    @GeneratedValue
    private Long id;

    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Instant expiryDate;

    private boolean revoked = false ;
}

