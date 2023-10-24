package com.inseminaplus.spring.security.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private String id;

    private String name;
    private String category;
    private String stock;
    private String value;
    private String race;

    public Product() {

    }

    public Product(String name, String category, String stock, String value, String race) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.value = value;
        this.race = race;
    }

    public String getRace() {
        return this.race;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", stock='" + stock + '\'' +
                ", value='" + value + '\'' +
                ", category='" + category + '\'' +
                ", race= '" + this.race + '\'' +
                '}';
    }
}
