package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.ReviewCreateDTO;
import ru.itis.models.Review;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T06:42:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toReview(ReviewCreateDTO reviewCreateDTO) {
        if ( reviewCreateDTO == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.productId( reviewCreateDTO.getProductId() );
        review.title( reviewCreateDTO.getTitle() );
        review.description( reviewCreateDTO.getDescription() );
        review.rating( reviewCreateDTO.getRating() );

        return review.build();
    }

    @Override
    public ReviewCreateDTO toReviewCreateDTO(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewCreateDTO reviewCreateDTO = new ReviewCreateDTO();

        reviewCreateDTO.setProductId( review.getProductId() );
        reviewCreateDTO.setTitle( review.getTitle() );
        reviewCreateDTO.setDescription( review.getDescription() );
        reviewCreateDTO.setRating( review.getRating() );

        return reviewCreateDTO;
    }
}
