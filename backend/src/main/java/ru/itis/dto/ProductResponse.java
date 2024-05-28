package ru.itis.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProductResponse<T> {
    private String _id;
    private List<String> categories;
    private List<String> tags;
    private String title;
    private String link;
    private String image;
    private double initialRating;
    private List<Characteristic> characteristics;
    private int price;
    private int oldPrice;
    private int credit;
    private String description;
    private String bigImage;
    private AdditionalMeta additionalMeta;
    private String companyId;
    private int clicks;
    private List<T> reviews;
    private int reviewCount;
    private double reviewAvg;
    private String advantages;
    private String disAdvantages;

    @Getter @Setter
    public static class Characteristic {
        private String name;
        private String value;
    }
    @Getter @Setter
    public static class AdditionalMeta {
        private String metaTitle;
        private String metaDescription;
        private String _id;
    }

    @Getter @Setter
    public static class Review implements ru.itis.util.Review {
        private String _id;
        private String name;
        private String title;
        private String description;
        private int rating;
        private String productId;
        private String createdAt;
        private String updatedAt;
        private int __v;
    }
}
