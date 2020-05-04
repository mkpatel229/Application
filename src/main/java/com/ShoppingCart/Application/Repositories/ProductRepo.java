package com.ShoppingCart.Application.Repositories;

import com.ShoppingCart.Application.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByNameIgnoreCaseStartingWith(String name);

    List<Product> findByDiscountGreaterThan(double discount);
}
