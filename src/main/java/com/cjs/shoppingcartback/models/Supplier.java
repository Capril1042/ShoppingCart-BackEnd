package com.cjs.shoppingcartback.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "supplier")
public class Supplier
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierid;

    @Column(nullable = false)
    private String suppliername;

    @JsonIgnore
    @ManyToMany(mappedBy = "suppliers")
    @JsonIgnoreProperties("suppliers")
    private Set<Product> products = new HashSet<>();
}
