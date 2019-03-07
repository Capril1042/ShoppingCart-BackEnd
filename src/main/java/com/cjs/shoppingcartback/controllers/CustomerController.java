package com.cjs.shoppingcartback.controllers;


import com.cjs.shoppingcartback.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController
{
//    @Autowired
//    ProductRepository productrepos;


    //TODO add endpoints for products

    // TODO add endpoints for items

    //TODO- endpoints for cart
    // get all items in cart - customer/cart/{customerid}
    // remove items from cart - customer/{customerid}/cart/{itemid}
    // adds item to cart customer/{customerid}/cart/{itemid}

    // TODO- endpoints for order
    // get orders
    // add order


}
