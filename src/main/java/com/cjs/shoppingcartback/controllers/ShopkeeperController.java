package com.cjs.shoppingcartback.controllers;

import com.cjs.shoppingcartback.models.Order;
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

    @Autowired
    ProductRepository productrepos;

    @Autowired
    OrderRepository orderrepos;

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
        } else
        {
            return null;
        }
    }

    //TODO This does not work-fix it
    @GetMapping("/supplier/name/{name}")
    public List<Supplier> getSupplierByName(@PathVariable String name)
    {
        return supplierrepos.findSupplierBySuppliernameLike(name);
    }

    //TODO this works but clean it up
    @PostMapping("/add/supplier")
    public Supplier newSupplier(@RequestBody Supplier supplier) throws URISyntaxException
    {
        return supplierrepos.save(supplier);
    }


    //TODO add post and delete endpoints for supplier
    // update supplier
    // delete supplier?

    //TODO add endpoints for Products
    //get products all and by id and by name
    // count quainity of items with product id
    // update product price
    // update product
    // add new product

    //TODO add Endpoints for items
    //add items to product by supplier
    //remove items


    //TODO add endpoints for Orders

    @GetMapping("/orders")
    public List<Order> getAllOrders()
    {
        return orderrepos.findAll();
    }

    @GetMapping("/order/id/{id}")
    public Optional<Order> getOrderById(@PathVariable long id)
    {
        Optional<Order> foundOrder = orderrepos.findById(id);
        if (foundOrder.isPresent())
        {
            return foundOrder;
        } else
        {
            return null;
        }
    }

   @GetMapping("/orders/custid/{id}")
    public List<Order> getOrdersByCustid(@PathVariable long id)
   {
       List<Order> foundOrders = orderrepos.findOrdersByCustomer_Custid(id);
       if (foundOrders.isEmpty())
       {
           return null
       }
       else
       {
           return foundOrders;
       }

   }

    @GetMapping("/orders/status/{orderstatus}")
    public List<Order> OrdersByStatus(@PathVariable String orderstatus)
    {
        List<Order> foundOrders = orderrepos.getAllByOrderstatusEquals(orderstatus);
        if (foundOrders.isEmpty())
        {
            return null;
        }
        else
        {
            return foundOrders;
        }
    }
    // update order status

    // get total price of order



}
