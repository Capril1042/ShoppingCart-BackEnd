package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long>
{
    @Query(value = "select * from shopping.cart where custid=:id;", nativeQuery = true)
    List<Cart> getCartByCustomerId(long id);
}
