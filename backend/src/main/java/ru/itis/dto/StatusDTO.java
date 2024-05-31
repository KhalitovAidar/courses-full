package ru.itis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter @Setter
public class StatusDTO {
    private HttpStatus code;
}
