package ru.itis.api;

import ru.itis.dto.CategorySecondDTO;
import ru.itis.dto.CourseResponseDTO;
import ru.itis.dto.RequestFindDTO;
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

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseApiService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Cacheable(value = "secondCourses", key = "#requestFindDTO.firstCategory")
    public List<CategorySecondDTO> getSecondCoursesByFirstCourse(RequestFindDTO requestFindDTO) throws JsonProcessingException {
        String url = "https://courses-top.ru/api/top-page/find";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        String requestBody = objectMapper.writeValueAsString(requestFindDTO);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        return objectMapper.readValue(response.getBody(), new TypeReference<List<CategorySecondDTO>>() {});
    }

    @Cacheable(value = "courseByAlias", key = "#alias")
    public CourseResponseDTO getCourseByAlias(String alias) throws Exception {
        String url = String.format("https://courses-top.ru/api/top-page/byAlias/%s", alias);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return objectMapper.readValue(response.getBody(), CourseResponseDTO.class);
    }
}
