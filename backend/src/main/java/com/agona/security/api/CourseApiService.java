package com.agona.security.api;

import com.agona.security.dto.CategorySecondDTO;
import com.agona.security.dto.CourseResponseDTO;
import com.agona.security.dto.RequestFindDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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

    public List<CategorySecondDTO> getSecondCoursesByFirstCourse(int firstCategory) throws JsonProcessingException {
        String url = "https://courses-top.ru/api/top-page/find";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        RequestFindDTO requestBodyDTO = new RequestFindDTO(firstCategory);
        String requestBody = objectMapper.writeValueAsString(requestBodyDTO);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        return objectMapper.readValue(response.getBody(), new TypeReference<List<CategorySecondDTO>>() {});
    }

    public CourseResponseDTO getCourseByAlias(String alias) throws Exception {
        String url = "https://courses-top.ru/api/top-page/byAlias/{}".formatted(alias);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return objectMapper.readValue(response.getBody(), CourseResponseDTO.class);
    }
}
