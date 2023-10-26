package com.inseminaplus.spring.security.mongodb.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name= "date")
    private Date date;

    @Column(name = "situation")
    private String situation;

    @Column(name = "value")
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Order() {

    }

    public Order(Date date, String situation, double value, Client client){
        this.date = date;
        this.situation = situation;
        this.value = value;
        this.client = client;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setSituation(String situation){
        this.situation = situation;
    }

    public void setValue(Double value){
        this.value = value;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Date getDate(){
        return this.date;
    }

    public String getSituation(){
        return this.situation;
    }

    public Double getValue(){
        return this.value;
    }

    public Client getClient() {
        return this.client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + this.id +
                ", date='" + this.date + '\'' +
                ", situation='" + this.situation + '\'' +
                ", value=" + this.value +
                ", client='" + this.client + '\'' +
                '}';
    }
}
