package com.cjs.shoppingcartback.repositories;


import com.cjs.shoppingcartback.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>
{
    @Query(value = "select * from item where productid =:id", nativeQuery = true)
    List<Item> findItemByProductId(long id);

    @Query(value = "select * from shopping.item where bought= false && cartid is null && productid = :productid", nativeQuery = true)
    List<Item> getItemsStockedbyProductid(long productid);

    @Modifying
    @Transactional
    @Query(value = "update shopping.item Set bought= true, incart= false, cartid =null where cartid=:cartid;", nativeQuery = true)
    List<Item> updateorderedItems(long cartid);

    @Query(value = "select * from shopping.item where cartid =:id", nativeQuery = true)
    List<Item> itemsInCart(long id);

    @Modifying
    @Query(value = "update shopping.item Set bought= false, incart= true, cartid =:cartid where itemid=:itemid;",nativeQuery = true)
    Item addItemToCart(long cartid,long itemid);

    @Query(value = "update shopping.item Set bought= false, incart= false, cartid =null where cartid=:cartid;", nativeQuery = true)
    Item removeItemFromCart(long id);
}
