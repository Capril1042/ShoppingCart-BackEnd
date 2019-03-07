package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
