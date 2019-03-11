package com.cjs.shoppingcartback.service;


import com.cjs.shoppingcartback.models.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}

