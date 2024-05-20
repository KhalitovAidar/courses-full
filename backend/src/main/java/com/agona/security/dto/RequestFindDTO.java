package com.agona.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestFindDTO {
    private int firstCategory;

    public RequestFindDTO(int firstCategory) {
        this.firstCategory = firstCategory;
    }
}
