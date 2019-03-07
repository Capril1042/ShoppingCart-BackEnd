package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>
{
    List<Order> findOrdersByCustomer_Custid(long id);


    List<Order> getAllByOrderstatusEquals(String orderstatus);

}
