package com.ShoppingCart.Application;

import com.ShoppingCart.Application.Models.Product;
import com.ShoppingCart.Application.Models.User;
import com.ShoppingCart.Application.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application {

	@Autowired
	UserRepo userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostConstruct
	void userDetail(){
		//Add sample user
		List<User> users = new ArrayList<>();
		users.add(new User("Admin",passwordEncoder.encode("admin"),"ADMIN"));
		users.add(new User("User",passwordEncoder.encode("user")));
		userRepo.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
