package ru.itis.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dto.ReviewCreateDTO;
import ru.itis.service.ContentService;
import ru.itis.service.JwtService;

@RestController
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;
    public static final String BEARER_PREFIX = "Bearer ";
    private final JwtService jwtService;
    public static final String HEADER_NAME = "Authorization";

    @PostMapping("/reviews/set")
    public void createReview(@RequestBody ReviewCreateDTO reviewCreateDTO, HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER_NAME);
        String jwtToken = authHeader.substring(BEARER_PREFIX.length());
        String userName = jwtService.extractUsername(jwtToken);

        contentService.createReview(reviewCreateDTO, userName);
    }
}
