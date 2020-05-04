package com.ShoppingCart.Application.Repositories;

import com.ShoppingCart.Application.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
