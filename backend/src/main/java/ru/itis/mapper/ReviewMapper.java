package ru.itis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.itis.dto.ReviewCreateDTO;
import ru.itis.models.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Review toReview(ReviewCreateDTO reviewCreateDTO);

    ReviewCreateDTO toReviewCreateDTO(Review review);
}