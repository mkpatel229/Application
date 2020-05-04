package com.ShoppingCart.Application.Services;

import com.ShoppingCart.Application.DTO.ApiError;
import com.ShoppingCart.Application.DTO.UserUpadte;
import com.ShoppingCart.Application.Jwt.JwtUtil;
import com.ShoppingCart.Application.Models.Customer;
import com.ShoppingCart.Application.Repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseEntity<?> register(Customer customer) {
        try {
            customer.getUser().setPassword(passwordEncoder.encode(customer.getUser().getPassword()));
            customer = customerRepo.save(customer);
            return new ResponseEntity(customer,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<ApiError>(new ApiError(HttpStatus.BAD_REQUEST,"Username is not valid"), HttpStatus.BAD_REQUEST);
        }
    }

    public Customer getCustomer(Integer customerId) throws Exception {
        return customerRepo.findById(customerId).
                orElseThrow(()->new Exception("NO customer is not register with id "+customerId));
    }

    public ResponseEntity<?> update(String token, UserUpadte userUpadte, Integer customerId) throws Exception {
        String username = null;
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            username = jwtTokenUtil.extractUsername(jwt);
        }
        Customer customer = getCustomer(customerId);
        if(!customer.getUser().getUserId().equals(username)){
            return  new ResponseEntity(
                    new ApiError(HttpStatus.BAD_REQUEST,"customer is not authorized with userId "+username),HttpStatus.BAD_REQUEST);
        }
        customer.setName(userUpadte.getName());
        customer.getUser().setPassword(userUpadte.getPassword());
        register(customer);
        return ResponseEntity.ok(customer);
    }
}
