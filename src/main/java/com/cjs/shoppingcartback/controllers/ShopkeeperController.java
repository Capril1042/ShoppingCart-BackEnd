package com.cjs.shoppingcartback.controllers;

import com.cjs.shoppingcartback.models.*;
import com.cjs.shoppingcartback.repositories.ItemRepository;
import com.cjs.shoppingcartback.repositories.OrderRepository;
import com.cjs.shoppingcartback.repositories.ProductRepository;
import com.cjs.shoppingcartback.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    ItemRepository itemrepos;

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

    //TODO This works but not for duplicate names? fix model so that suppliername must be unique?
    @GetMapping("/supplier/name/{name}")
    public List<Supplier> getSupplierByName(@PathVariable String name)
    {
        List<Supplier> foundSupplier = supplierrepos.findAllBySuppliernameEquals(name);
        if (foundSupplier.isEmpty())
        {
            return null;
        }
        else
        {
            return foundSupplier;
        }
    }

    //TODO this works but clean it up
    @PostMapping("/add/supplier")
    public Supplier newSupplier(@RequestBody Supplier supplier) throws URISyntaxException
    {
        return supplierrepos.save(supplier);
    }


    @PutMapping("/supplier/id/{id}")
    public List<Supplier> updateSupplier(@RequestBody Supplier newSupplier, @PathVariable long id) throws URISyntaxException
    {
        Optional<Supplier> updatedSupplier = supplierrepos.findById(id);
        if (updatedSupplier.isPresent())
        {
            newSupplier.setSupplierid(id);
            supplierrepos.save(newSupplier);

            return java.util.Arrays.asList(newSupplier);
        }
        else
        {
            return updatedSupplier.stream().collect(Collectors.toList());
        }
    }

    @GetMapping("/product/countinventory/{id}")
    public int countInventory(@PathVariable long id)
    {
        return itemrepos.findCountOfProduct(id);
    }

    // count quantity of items of a specific product that are in a carts
    @GetMapping("/product/countpending/{id}")
    public int countPending(@PathVariable long id)
    {
        return itemrepos.findPendingInventory(id);
    }



    // update product price

    // add new product to a supplier already in database

    //add a new product with a new supplier



    @GetMapping("/items")
    public List<Item> getAllItems()
    {
        return itemrepos.findAll();
    }

    // get all items with supplierid

    // get all items with produt id
    @GetMapping("/items/productid/{id}")
    public List<Item> getitemsbyProduct(@PathVariable long id)
    {
        return itemrepos.findItemByProductId(id);
    }

    // add items with product id and supplier id


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
           return null;
       }
       else
       {
           return foundOrders;
       }

   }

//    @GetMapping("/orders/status/{orderstatus}")
//    public List<Order> OrdersByStatus(@PathVariable String orderstatus)
//    {
//        List<Order> foundOrders = orderrepos.getAllByOrderstatusEquals(orderstatus);
//        if (foundOrders.isEmpty())
//        {
//            return null;
//        }
//        else
//        {
//            return foundOrders;
//        }
//    }

    // update order status by customerid

    //TODO when order is completed the items must be removed from??
//    @PutMapping("/order/id/{id}")
//    public List<Order> updateOrderStatusByOrderId(@RequestBody Order neworder, @PathVariable long id) throws URISyntaxException
//    {
//        Optional<Order> updatedOrder = orderrepos.findById(id);
//        if (updatedOrder.isPresent())
//        {
//            neworder.setOrderstatus("complete");
//            orderrepos.save(neworder);
//
//            return java.util.Arrays.asList(neworder);
//        }
//        else
//        {
//            return updatedOrder.stream().collect(Collectors.toList());
//        }
//    }

    // update order status by order id



    // get total price of order




}
