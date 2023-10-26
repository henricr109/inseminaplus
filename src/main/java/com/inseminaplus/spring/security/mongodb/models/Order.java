package com.inseminaplus.spring.security.mongodb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name= "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    private long id;
    @Column(name= "date")
    private Date date;
    @Column(name = "situation")
    private boolean situation;
    @Column(name = "value")
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Client client;
    public Order() {

    }

    public Order(Date date, boolean situation, double value, Client client){
        this.date = date;
        this.situation = situation;
        this.value = value;
        this.client = client;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setSituation(boolean situation){
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

    public boolean getSituation(){
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
