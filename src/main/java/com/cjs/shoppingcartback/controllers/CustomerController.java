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
        // get all items by cartid - returns items in cart
        // add/remove item to cart == update item by item id
        // add an order - also updates items by cart id/removing cart id
    @GetMapping("/cart/custid/{id}")
    public List<Cart> getCustomersCart(@PathVariable long id)
    {
        return cartrepos.getCartByCustomerId(id);
    }

    @GetMapping("/cart/items/{id}")
    public List<Item> allCartItems(@PathVariable long id)
    {
        return itemrepos.itemsInCart(id);
    }

    @GetMapping("cart/{cartid}/add/item/{itemid}")
    public Item addItemToCart(@PathVariable long cartid, long itemid)
    {
        return itemrepos.addItemToCart(cartid, itemid);
    }

    @GetMapping("cart/remove/item/{itemid}/{cartid}")
    public Item removefromcart(@PathVariable long itemid,long cartid)

    {
        return itemrepos.removeItemFromCart(itemid, cartid);
    }








}
