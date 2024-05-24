package ru.itis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponseDTO {
    @JsonProperty("_id")
    private String id;
    private List<String> tags;
    private int firstCategory;
    private String secondCategory;
    private String alias;
    private String title;
    private String category;
    private String tagsTitle;
    private String metaTitle;
    private String metaDescription;
    private List<String> advantages;
    private String createdAt;
    private String updatedAt;
    private int __v;
    private HHDTO hh;
    private List<String> qas;
    private List<String> addresses;
    private String categoryOn;
    private BlogDTO blog;
    private Sravnikus sravnikus;
    private LearningClubDTO learningclub;
}