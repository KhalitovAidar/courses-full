package com.agona.security.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Sravnikus {
    private String metaTitle;
    private String metaDescription;
    private String seoText;
    private List<QADTO> qas;
    private String _id;
}