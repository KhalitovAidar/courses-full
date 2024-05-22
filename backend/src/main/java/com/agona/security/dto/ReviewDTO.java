package com.agona.security.dto;

import com.agona.security.models.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class ReviewDTO {
    private UUID id;

    private String userName;

    private String title;

    private String description;

    private int rating;
}
