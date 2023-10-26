package com.inseminaplus.spring.security.mongodb.models;

import java.util.Date;

import jakarta.persistence.*;

public class Item {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public Item() {

    }

    public Item(String name, Double value, Order order){
        this.name = name;
        this.value = value;
        this.order = order;
    }

    
    public void setName(String name){
        this.name = name;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void setValue(Double value){
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public Double getValue(){
        return this.value;
    }

    public Order getOrder(){
        return this.order;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", value=" + this.value +
                ", order='" + this.order + '\'' +
                '}';
    }
}
