package com.ShoppingCart.Application.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/Welcome")
    public String Hello(){
        return "Welcome to ShoppingCart Application";
    }
}
