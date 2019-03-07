package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long>
{
    List<Supplier> findAllBySuppliernameEquals(String name);
}
