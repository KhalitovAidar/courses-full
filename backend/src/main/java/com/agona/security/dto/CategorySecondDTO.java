package com.agona.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CategorySecondDTO {
    @JsonProperty("_id")
    private Map<String, String> id;
    private List<PageDTO> pages;
}