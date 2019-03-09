package com.cjs.shoppingcartback.controllers;



import com.cjs.shoppingcartback.models.Item;
import com.cjs.shoppingcartback.models.Product;
import com.cjs.shoppingcartback.repositories.ItemRepository;
import com.cjs.shoppingcartback.repositories.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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


    @ApiOperation(value = "returns a list of all products", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productrepos.findAll();
    }

    @ApiOperation(value = "returns a list of products with a certain productid", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/product/id/{id}")
    public Optional<Product> getProductById(@PathVariable long id)
    {
        return productrepos.findById(id);
    }

    @ApiOperation(value = "returns a list of products that are instock based on productid", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "Not authorized for this resource"),
                    @ApiResponse(code = 403, message = "Access to resource forbidden"),
                    @ApiResponse(code = 404, message = "Resource not found")
            })
    @GetMapping("/products/instock/{id}")
    public List<Item> itemStockOfProduct(@PathVariable long id)
    {
        return itemrepos.getItemsStockedbyProductid(id);
    }

}
