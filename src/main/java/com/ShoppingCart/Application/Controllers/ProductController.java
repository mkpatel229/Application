package com.ShoppingCart.Application.Controllers;

import com.ShoppingCart.Application.DTO.ProductResponse;
import com.ShoppingCart.Application.Models.Product;
import com.ShoppingCart.Application.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){

        return  productService.addProduct(product);
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{prodId}/details")
    public Optional<Product> getProductDetails(@PathVariable Integer prodId){
        return productService.getDetails(prodId);
    }

    @GetMapping(value = "/searchproduct/{name}")
    public ProductResponse searchProduct(@PathVariable String name) {
        return productService.searchProduct(name);
    }

    @GetMapping(value = "/deals")
    public ProductResponse getDeals(){
        return productService.getDeals();
    }
}
