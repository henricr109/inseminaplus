package com.inseminaplus.spring.security.mongodb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.Transaction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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

    public Order() {

    }

    public Order(String date, String situation, String value){
        this.date = date;
        this.situation = situation;
        this.value = value;
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
