package com.cjs.shoppingcartback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name= "cart")
public class Cart
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartid;

    private String cartname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "custid", referencedColumnName = "custid")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    @JsonIgnoreProperties("cart")
    private Set<Item> items = new HashSet<>();

}
