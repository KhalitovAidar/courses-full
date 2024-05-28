package ru.itis.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductFindRequest {
    private String category;
    private int limit;
}