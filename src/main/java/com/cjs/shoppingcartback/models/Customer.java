package com.cjs.shoppingcartback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custid;

    @Column(nullable = false)
    private String custname;

    @Column(nullable = false)
    private String custemail;

    @Column(nullable = false)
    private String shippingaddress;

    @Column(nullable = false)
    private String billingaddress;

    @Column(nullable = false)
    private String custphone;

    @Column(nullable = false)
    private String paymentmethod;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    private Set<Order> orders = new HashSet<>();
   




}
