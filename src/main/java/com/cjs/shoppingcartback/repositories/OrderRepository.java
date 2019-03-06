package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>
{
}
