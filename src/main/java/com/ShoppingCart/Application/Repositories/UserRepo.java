package com.ShoppingCart.Application.Repositories;

import com.ShoppingCart.Application.Models.Customer;
import com.ShoppingCart.Application.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
