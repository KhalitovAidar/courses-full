package ru.itis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Sign in request")
public class SignInDTO {
    @Schema(description = "Username", example = "Aidar")
    @Size(min = 5, max = 50, message = "Username must be in the range from 3 to 100")
    @NotBlank(message = "Username can't be empty")
    private String username;

    @Schema(description = "Password", example = "password")
    @Size(min = 8, max = 255, message = "Password must be in the range from 5 to 255")
    @NotBlank(message = "Password can't be empty")
    private String password;
}
