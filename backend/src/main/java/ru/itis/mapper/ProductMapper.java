package ru.itis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.itis.dto.ProductResponse;
import ru.itis.dto.ProductResponseFront;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "reviews", ignore = true)
    ProductResponseFront toProductResponseFront(ProductResponse productResponse);
}