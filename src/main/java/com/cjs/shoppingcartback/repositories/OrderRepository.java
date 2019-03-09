package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>
{
    List<Order> findOrdersByCustomer_Custid(long id);

    List<Order> getAllByOrdercompleteIsTrue();

    List<Order> getAllByOrdercompleteIsFalse();

    @Modifying
    @Query(value= "update shopping.orders Set ordercomplete= true where orderid =:id", nativeQuery = true)
    Order updateOrderStatusSk(long id);


}
