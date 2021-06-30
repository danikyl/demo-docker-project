package com.danielsoftware.aplication.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
