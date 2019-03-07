package com.cjs.shoppingcartback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "item")
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemid;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productid", nullable = false)
    @JsonIgnoreProperties("item")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "cartid")
    @JsonIgnore
    private Cart cart;
}
