package com.agona.security.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "product_id"})})
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private int rating;
}
