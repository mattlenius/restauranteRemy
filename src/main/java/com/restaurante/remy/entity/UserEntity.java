package com.restaurante.remy.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Data
@Getter
@Setter
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 16)
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @Column(name = "create_time")
    private Instant createTime;

}