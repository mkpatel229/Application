package com.ShoppingCart.Application.Repositories;

import com.ShoppingCart.Application.Models.CompositeKey;
import com.ShoppingCart.Application.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, CompositeKey> {

}
