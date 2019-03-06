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

    @Column(nullable = false)
    private long custid;

    @OneToMany(mappedBy = "cart")
    @JsonIgnoreProperties("cart")
    private Set<Item> items = new HashSet<>();

}
