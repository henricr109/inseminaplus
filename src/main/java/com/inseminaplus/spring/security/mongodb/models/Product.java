package com.inseminaplus.spring.security.mongodb.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Product {
    @Id
    private String productId;
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @NotBlank
    private String stock;
    @NotBlank
    private String value;
    @NotBlank
    private String race;
    @NotBlank
    private String description;
    @NotBlank
    private String fkUserId;
    
    public Product() {

    }

    public Product( String name, String category, String stock, String value, String race, String description, String fkUserId) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.value = value;
        this.race = race;
        this.description = description;
        this.fkUserId = fkUserId;
    }

    public String getRace() {
        return this.race;
    }

    public String getId() {
        return productId;
    }

    public void setId(String id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace (String race) {
        this.race = race;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(String fkUserId) {
        this.fkUserId = fkUserId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", value=" + value +
                ", race='" + race + '\'' +
                ", description='" + description + '\'' +

                '}';
    }
}
