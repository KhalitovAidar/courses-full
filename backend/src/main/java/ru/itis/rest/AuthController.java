package ru.itis.rest;

import ru.itis.dto.JwtAuthenticationResponseDTO;
import ru.itis.dto.SignInDTO;
import ru.itis.dto.SignUpDTO;
import ru.itis.service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;
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
}