package com.cjs.shoppingcartback.controllers;

import com.cjs.shoppingcartback.models.Supplier;
import com.cjs.shoppingcartback.repositories.OrderRepository;
import com.cjs.shoppingcartback.repositories.ProductRepository;
import com.cjs.shoppingcartback.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/shopkeep/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopkeeperController
{
    @Autowired
    SupplierRepository supplierrepos;

//    @Autowired
//    ProductRepository productrepos;
//
//    @Autowired
//    OrderRepository orderrepos;

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers()
    {
        return supplierrepos.findAll();
    }

    @GetMapping("/supplier/id/{id}")
    public Optional<Supplier> getSupplierById(@PathVariable long id)
    {
        Optional<Supplier> foundSupplier = supplierrepos.findById(id);
        if (foundSupplier.isPresent())
        {
            return foundSupplier;
        }
        else
        {
            return null;
        }
    }

    @GetMapping("/supplier/{name}")
    public List<Supplier> getSupplierByName(@PathVariable String name)
    {
        return supplierrepos.findSupplierBySuppliernameLike(name);
    }

    @PostMapping("/supplier")
    public Supplier newSupplier(@RequestBody Supplier supplier) throws URISyntaxException
    {
        return supplierrepos.save(supplier);
    }

    //TODO add post and delete endpoints for supplier
        // update supplier
        // delete supplier?

    //TODO add endpoints for Products
        //get products all and by id and by name
        // update product price
        // update product
        // add new product

    //TODO add endpoints for Orders
        // get all orders
        // get all orders by orderid
        // get all orders by customerid
        // update order status

}
