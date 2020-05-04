package com.ShoppingCart.Application.Services;

import com.ShoppingCart.Application.DTO.ProductResponse;
import com.ShoppingCart.Application.Models.Product;
import com.ShoppingCart.Application.Repositories.ProductRepo;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product){

        return productRepo.save(product);
    }

    public List<Product> getAllProduct() {

        return productRepo.findAll();
    }

    public ProductResponse searchProduct(String name) {
        ProductResponse response = new ProductResponse();
        List<Product> productList = productRepo.findByNameIgnoreCaseStartingWith(name);

        productList = StreamEx.of(productList).sorted(Comparator.comparingDouble(Product::getPrice)).distinct(Product::getName).toList();

        response.setProductList(productList);
        if(productList.size() == 0){
            response.setMessage("No match product found");
            return response;
        }
        response.setMessage("Success");
        return response;
    }

    public Optional<Product> getDetails(Integer prodId) {
        return productRepo.findById(prodId);
    }

    public ProductResponse getDeals() {
        ProductResponse productResponse = new ProductResponse();

        List<Product> productList = productRepo.findByDiscountGreaterThan(0);
        if(productList.size() == 0){
            productResponse.setMessage("No deals available today");
            return productResponse;
        }
        productList.forEach(x->x.setOfferPrice(x.getPrice()*(100-x.getDiscount())/100));
        productResponse.setProductList(productList);
        productResponse.setMessage("Success");
        return productResponse;
    }
}
