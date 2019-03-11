package com.cjs.shoppingcartback.repositories;

import com.cjs.shoppingcartback.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
