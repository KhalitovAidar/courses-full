package ru.itis.dto;

import lombok.Getter;
import lombok.Setter;
import ru.itis.util.Review;

import java.util.UUID;

@Getter
@Setter
public class ReviewCreateDTO {
    private String productId;

    private String title;

    private String description;

    private int rating;
}