package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long>
{
}
