package ru.itis.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.itis.dto.*;
import ru.itis.models.User;
import ru.itis.service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.itis.service.JwtService;
import ru.itis.service.UserService;

import java.util.List;

import static ru.itis.controller.ContentController.BEARER_PREFIX;
import static ru.itis.controller.ContentController.HEADER_NAME;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final UserService userService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public JwtAuthenticationResponseDTO signUp(@RequestBody @Valid SignUpDTO signUpDTO) {
        return authenticationService.signUp(signUpDTO);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponseDTO signIn(@RequestBody @Valid SignInDTO signInDTO) {
        return authenticationService.signIn(signInDTO);
    }

    @PostMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AdminResponseDTO isAdmin() {
        return AdminResponseDTO.builder().users(userService.getAll()).build();
    }
}