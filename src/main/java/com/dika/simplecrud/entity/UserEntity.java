package com.dika.simplecrud.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, name = "nama")
    private String name;

    @Column(nullable = false, unique = true)
    private String email;


}
