package ru.itis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.enums.Role;

import java.util.UUID;

@Builder
@Getter @Setter
public class UserDTO {
    @JsonProperty("_id")
    private UUID id;
    private String username;
    private String email;
    private Role role;
}