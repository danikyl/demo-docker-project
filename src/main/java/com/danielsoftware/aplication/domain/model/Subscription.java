package com.danielsoftware.aplication.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Data
public class Subscription {
    @Id
    private String id;

    @ManyToOne()
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
