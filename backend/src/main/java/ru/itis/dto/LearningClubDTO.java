package ru.itis.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LearningClubDTO {
    private String metaTitle;
    private String metaDescription;
    private String seoText;
    private List<QADTO> qas;
    private String _id;
}