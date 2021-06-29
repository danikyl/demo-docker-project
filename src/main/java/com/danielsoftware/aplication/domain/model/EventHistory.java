package com.danielsoftware.aplication.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EventHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name="subscription_id", referencedColumnName = "id")
    private Subscription subscription;

    @ManyToOne()
    @JoinColumn(name="status_id", referencedColumnName = "id")
    private Status status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
