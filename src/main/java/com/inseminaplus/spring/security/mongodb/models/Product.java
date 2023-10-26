package com.inseminaplus.spring.security.mongodb.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name="category")
    private String category;
    @Column(name="stock")
    private int stock;
    @Column(name="value")
    private int value;
    @Column(name="race")
    private String race;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Client client;

    public Product() {

    }

    public Product(String name, String category, int stock, int value, String race) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.value = value;
        this.race = race;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getRace() {
        return this.race;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
