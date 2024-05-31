package ru.itis.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dto.AdminResponseDTO;
import ru.itis.dto.DeleteUserDTO;
import ru.itis.dto.ReviewCreateDTO;
import ru.itis.dto.StatusDTO;
import ru.itis.service.ContentService;
import ru.itis.service.JwtService;
import ru.itis.service.UserService;

@RestController
@RequiredArgsConstructor
@Tag(name = "Контент")
public class ContentController {
    private final ContentService contentService;
    private final UserService userService;
    public static final String BEARER_PREFIX = "Bearer ";
    private final JwtService jwtService;
    public static final String HEADER_NAME = "Authorization";

    @PostMapping("/reviews/set")
    @Operation(summary = "Создание отзыва")
    public void createReview(@RequestBody ReviewCreateDTO reviewCreateDTO, HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER_NAME);
        String jwtToken = authHeader.substring(BEARER_PREFIX.length());
        String userName = jwtService.extractUsername(jwtToken);

        contentService.createReview(reviewCreateDTO, userName);
    }

    @PostMapping("/delete-user")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@RequestBody DeleteUserDTO dto) {
        userService.deleteByUsername(dto.getUsername());
    }
}
