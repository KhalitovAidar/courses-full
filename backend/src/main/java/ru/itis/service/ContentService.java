package ru.itis.service;

import ru.itis.dto.ProductResponseFront;
import ru.itis.dto.ReviewCreateDTO;
import ru.itis.dto.ReviewDTO;
import ru.itis.mapper.ProductMapper;
import ru.itis.mapper.ReviewMapper;
import ru.itis.models.Review;
import ru.itis.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;

    public void createReview(ReviewCreateDTO reviewCreateDTO, String userName) {
        Review review = reviewMapper.toReview(reviewCreateDTO);
        review.setUser(userRepository.findByUsername(userName).orElseThrow(
                () -> new RuntimeException("User not found with username: " + userName))
        );
        review.setId(UUID.randomUUID());
        reviewRepository.save(review);
    }

    public List<ReviewDTO> getReviewsByProductId(String productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);

        return reviews.stream().map(review -> {
            return ReviewDTO.builder()
                    .id(review.getId())
                    .userName(review.getUser().getUsername())
                    .description(review.getDescription())
                    .title(review.getTitle())
                    .rating(review.getRating())
                    .createdAt(review.getCreatedAt())
                    .build();
        }).collect(Collectors.toList());
    }
}
