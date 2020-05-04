package com.ShoppingCart.Application.Controllers;

import com.ShoppingCart.Application.DTO.ApiError;
import com.ShoppingCart.Application.DTO.AuthenticationRequest;
import com.ShoppingCart.Application.DTO.AuthenticationResponse;
import com.ShoppingCart.Application.DTO.UserUpadte;
import com.ShoppingCart.Application.Jwt.JwtUtil;
import com.ShoppingCart.Application.Models.Customer;
import com.ShoppingCart.Application.Models.User;
import com.ShoppingCart.Application.Repositories.UserRepo;
import com.ShoppingCart.Application.Services.CustomerService;
import com.ShoppingCart.Application.Services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.hibernate.Session;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    UserRepo userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;


    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody Customer customer){
        return customerService.register(customer);

    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/{customerId}/update")
    public ResponseEntity<?> updateDetails(
            @RequestHeader("Authorization") String token, @RequestBody UserUpadte userUpadte, @PathVariable Integer customerId){
        try {
            return customerService.update(token,userUpadte,customerId);
        }
        catch (Exception e){
            return  new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
