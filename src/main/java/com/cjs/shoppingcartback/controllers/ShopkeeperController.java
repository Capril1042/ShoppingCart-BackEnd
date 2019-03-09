package com.cjs.shoppingcartback.controllers;

import com.cjs.shoppingcartback.models.*;
import com.cjs.shoppingcartback.repositories.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
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

    @Autowired
    CartRepository cartrepos;

    @ApiOperation(value = "returns a list of all suppliers", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers()
    {
        return supplierrepos.findAll();
    }

    @ApiOperation(value = "returns a list of suppliers with a certain supplierid", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
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

    @ApiOperation(value = "returns a list of suppliers by name", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
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

    @ApiOperation(value = "Adds a new Supplier", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @PostMapping("/add/supplier")
    public Supplier newSupplier(@RequestBody Supplier supplier) throws URISyntaxException
    {
        return supplierrepos.save(supplier);
    }

    @ApiOperation(value = "updates a supplier", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
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




    @PutMapping("/product/update/{id}")
    public List<Product> updateProduct(@RequestBody Product newproduct, @PathVariable long id) throws URISyntaxException
    {
        Optional<Product> updatedProduct = productrepos.findById(id);
        if (updatedProduct.isPresent())
        {
            productrepos.save(newproduct);

            return java.util.Arrays.asList(newproduct);
        }
        else
        {
            return updatedProduct.stream().collect(Collectors.toList());
        }
    }

    @ApiOperation(value = "returns all items", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/items")
    public List<Item> getAllItems()
    {
        return itemrepos.findAll();
    }


    @ApiOperation(value = "returns a list of items by productid", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/items/productid/{id}")
    public List<Item> getitemsbyProduct(@PathVariable long id)
    {
        return itemrepos.findItemByProductId(id);
    }

    @ApiOperation(value = "returns a list of all orders", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/orders")
    public List<Order> getAllOrders()
    {
        return orderrepos.findAll();
    }

    @ApiOperation(value = "returns a order by its orderid", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
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

    @ApiOperation(value = "returns a list of orders by customerid", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
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

    @ApiOperation(value = "returns completes orders", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/orders/status/complete")
    public List<Order> OrdersByStatusComplete()
    {
        List<Order> foundOrders = orderrepos.getAllByOrdercompleteIsTrue();
        if (foundOrders.isEmpty())
        {
            return null;
        }
        else
        {
            return foundOrders;
        }
    }

    @ApiOperation(value = "returns non completes orders", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/orders/status/notcomplete")
    public List<Order> OrdersByStatusNotComplete()
    {
        List<Order> foundOrders = orderrepos.getAllByOrdercompleteIsFalse();
        if (foundOrders.isEmpty())
        {
            return null;
        }
        else
        {
            return foundOrders;
        }
    }

    @GetMapping("/cart/custid/{id}")
    public List<Cart> getCustomersCart(@PathVariable long id)
    {
        return cartrepos.getCartByCustomerId(id);
    }


    @GetMapping("/order/update/{id}/cart/{cartid}")
    public Order updateOrder(@PathVariable long id, @PathVariable long cartid) throws URISyntaxException
    {
        itemrepos.updateorderedItems(cartid);
        return orderrepos.updateOrderStatusSk(id);

    }





}
