package com.ShoppingCart.Application;

import com.ShoppingCart.Application.Models.User;
import com.ShoppingCart.Application.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;



@SpringBootApplication
public class Application {

	@Autowired
	UserRepo userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostConstruct
	void userDetail(){
		userRepo.save(new User("Admin",passwordEncoder.encode("admin"),"ADMIN"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
