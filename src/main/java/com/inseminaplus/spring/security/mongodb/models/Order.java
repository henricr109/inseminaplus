package com.inseminaplus.spring.security.mongodb.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Order {
    @Id
    private String id;
    @NotBlank
    private String date;
    @NotBlank
    private String situation;
    @NotBlank
    private String value;
    @NotBlank
    private String fkUserId;
    @NotBlank
    private String productIds;


    public Order() {

    }

    public Order(String date, String situation, String value, String fkUserId, String productIds) {
        this.date = date;
        this.situation = situation;
        this.value = value;
        this.fkUserId = fkUserId;
        this.productIds = productIds;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setSituation(String situation){
        this.situation = situation;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getDate(){
        return this.date;
    }

    public String getSituation(){
        return this.situation;
    }

    public String getValue(){
        return this.value;
    }

    public String getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(String fkUserId) {
        this.fkUserId = fkUserId;
    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + this.id +
                ", date='" + this.date + '\'' +
                ", situation='" + this.situation + '\'' +
                ", value=" + this.value +
                '}';
    }
}
