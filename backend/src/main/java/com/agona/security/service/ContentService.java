package com.agona.security.service;

import com.agona.security.dto.ReviewDTO;
import com.agona.security.models.Review;
import com.agona.security.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ReviewRepository reviewRepository;

    public List<ReviewDTO> getReviewsByProductId(String productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);

        return reviews.stream().map(review -> {
            return ReviewDTO.builder()
                    .id(review.getId())
                    .userName(review.getUser().getUsername())
                    .title(review.getTitle())
                    .rating(review.getRating())
                    .build();
        }).collect(Collectors.toList());
    }
}
