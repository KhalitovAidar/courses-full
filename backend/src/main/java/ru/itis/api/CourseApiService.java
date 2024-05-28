package ru.itis.api;

import ru.itis.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import ru.itis.mapper.ProductMapper;
import ru.itis.service.ContentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseApiService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ContentService contentService;

//    @Cacheable(value = "secondCourses", key = "#requestFindDTO.firstCategory")
    public List<CategorySecondDTO> getSecondCoursesByFirstCourse(RequestFindDTO requestFindDTO) throws JsonProcessingException {
        String url = "https://courses-top.ru/api/top-page/find";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        String requestBody = objectMapper.writeValueAsString(requestFindDTO);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        return objectMapper.readValue(response.getBody(), new TypeReference<List<CategorySecondDTO>>() {});
    }

//    @Cacheable(value = "courseByAlias", key = "#alias")
    public CourseResponseDTO getCourseByAlias(String alias) throws Exception {
        String url = String.format("https://courses-top.ru/api/top-page/byAlias/%s", alias);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return objectMapper.readValue(response.getBody(), CourseResponseDTO.class);
    }

//    @Cacheable(value = "findProducts", key = "#request.category")
    public List<ProductResponseFront> findProducts(ProductFindRequest request) throws JsonProcessingException {
        String url = "https://courses-top.ru/api/product/find";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        String requestBody = objectMapper.writeValueAsString(request);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        List<ProductResponse> products = objectMapper.readValue(response.getBody(), new TypeReference<List<ProductResponse>>() {});

        return products.stream().map(
                productResponse -> {
                    List<ReviewDTO> reviewDTOS = contentService.getReviewsByProductId(productResponse.get_id());

                    ProductResponseFront productResponseFront = ProductMapper.INSTANCE.toProductResponseFront(productResponse);
                    productResponseFront.setReviews(reviewDTOS);
                    productResponseFront.setReviewCount(reviewDTOS.size());

                    double averageRating = reviewDTOS.stream()
                            .mapToInt(ReviewDTO::getRating)
                            .average()
                            .orElse(0.0);
                    productResponseFront.setReviewAvg(averageRating);

                    return productResponseFront;
                }
        ).toList();
    }
}
