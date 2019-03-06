package com.cjs.shoppingcartback.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="order")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;

    @ManyToOne
    @JoinColumn(name = "custid", nullable = false)
    @JsonIgnore
    private Customer customer;

    @Column(nullable=false)
    private String orderstatus;





}
