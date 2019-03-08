package com.cjs.shoppingcartback.controllers;



import com.cjs.shoppingcartback.models.Item;
import com.cjs.shoppingcartback.models.Product;
import com.cjs.shoppingcartback.repositories.ItemRepository;
import com.cjs.shoppingcartback.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/* This Controller is for Shopkeepers, Customers and Potential Customers */
@RestController
@RequestMapping(value = "/shop/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LandingController
{
    @Autowired
    ProductRepository productrepos;

    @Autowired
    ItemRepository itemrepos;

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productrepos.findAll();
    }

    @GetMapping("/product/id/{id}")
    public Optional<Product> getProductById(@PathVariable long id)
    {
        return productrepos.findById(id);
    }

    @GetMapping("/products/instock/{id}")
    public List<Item> itemStockOfProduct(@PathVariable long id)
    {
        return itemrepos.getItemsStockedbyProductid(id);
    }

}
