package com.cjs.shoppingcartback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;

    @Column(nullable = false)
    private String productname;

    private String productdescription;

    private String productimage;

    private double productprice;


    @ManyToMany
    @JoinTable(name="productsuppliers",
            joinColumns = {@JoinColumn(name = "productid")},
            inverseJoinColumns = {@JoinColumn(name = "supplierid")})
    @JsonIgnoreProperties("products")
    private Set<Supplier> suppliers = new HashSet<>();


    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private Set<Item> items = new HashSet<>();


}
