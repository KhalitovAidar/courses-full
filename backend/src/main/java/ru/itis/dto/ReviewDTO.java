package ru.itis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.util.Review;

import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
@Setter
public class ReviewDTO implements Review {
    @JsonProperty("_id")
    private UUID id;

    @JsonProperty("name")
    private String userName;

    private String title;

    private String description;

    private int rating;

    private Instant createdAt;
}