package com.ShoppingCart.Application.DTO;

import com.ShoppingCart.Application.Models.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ProductResponse {
    List<Product> productList;
    String message;
}
