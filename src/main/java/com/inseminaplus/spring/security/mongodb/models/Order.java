package com.inseminaplus.spring.security.mongodb.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String quantity;
    @NotBlank
    private String fkUserId;
    @NotBlank
    private String productId;
    private String orderId;
    @NotBlank
    private String buyerId;


    public Order() {

    }

    public Order(String date, String situation, String value, String quantity, String fkUserId, String productId, String orderId, String idBuyer) {
        this.date = date;
        this.situation = situation;
        this.value = value;
        this.quantity= quantity;
        this.fkUserId = fkUserId;
        this.productId = productId;
        this.orderId = orderId;
        this.buyerId = idBuyer;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
