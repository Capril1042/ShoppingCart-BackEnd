package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long>
{
}
