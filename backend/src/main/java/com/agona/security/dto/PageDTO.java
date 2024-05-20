package com.agona.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageDTO {
    private String alias;
    private String title;
    @JsonProperty("_id")
    private String id;
    private String category;
}
