package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>
{
}
