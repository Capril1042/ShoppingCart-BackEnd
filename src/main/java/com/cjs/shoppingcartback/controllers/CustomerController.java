package com.cjs.shoppingcartback.controllers;


import com.cjs.shoppingcartback.models.Cart;
import com.cjs.shoppingcartback.models.Item;
import com.cjs.shoppingcartback.models.Product;
import com.cjs.shoppingcartback.repositories.CartRepository;
import com.cjs.shoppingcartback.repositories.ItemRepository;
import com.cjs.shoppingcartback.repositories.OrderRepository;
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
    @Autowired
    CartRepository cartrepos;

    @Autowired
    OrderRepository orderrepos;

    @Autowired
    ItemRepository itemrepos;


    // TODO add endpoints for items

    //TODO- endpoints for cart
    // get all items in cart - customer/cart/{customerid}
//    @GetMapping("cart/items/{id}")
//    public List<Item> getItemsinCart(long id)
//    {
//        return itemrepos.getAllCartItems(id);
//    }
    // remove items from cart - customer/{customerid}/cart/{itemid}
    // adds item to cart customer/{customerid}/cart/{itemid}

    // TODO- endpoints for order
    // add order - adds an order with a statua of pending
    // removes cartid from order


    //cannot change or delete orders


}
