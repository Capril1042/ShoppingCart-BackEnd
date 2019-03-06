package com.cjs.shoppingcartback.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @ManyToOne
    @JoinColumn(name = "productid", nullable = false)
    @JsonIgnore
    private Product product;


}
