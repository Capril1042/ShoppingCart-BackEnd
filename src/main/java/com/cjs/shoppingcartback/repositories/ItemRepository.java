package com.cjs.shoppingcartback.repositories;


import com.cjs.shoppingcartback.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>
{
    @Query(value = "select * from item where productid =:id", nativeQuery = true)
    List<Item> findItemByProductId(long id);

    @Query(value = "select count(itemid) as inventory from item where productid = :id", nativeQuery = true)
    int findCountOfProduct(long id);

    @Query(value = "select count(cartid) as pendinginventory from item where productid= :id", nativeQuery = true)
    int findPendingInventory(long id);
//
//    @Query(value = "select item.productid, item.itemid from item where cartid =:id")
//    List<Item> getAllCartItems(long id);

    @Query(value = "select * from shopping.item where bought= false && cartid is null && productid = :productid", nativeQuery = true)
    List<Item> getItemsStockedbyProductid(long productid);

}
