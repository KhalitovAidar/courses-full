package ru.itis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.models.User;

import java.util.List;

@Builder
@Getter @Setter
public class AdminResponseDTO {
    private List<UserDTO> users;
}
