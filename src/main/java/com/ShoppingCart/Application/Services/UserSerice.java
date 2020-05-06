package com.ShoppingCart.Application.Services;

import com.ShoppingCart.Application.Models.User;
import com.ShoppingCart.Application.Repositories.UserRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class UserSerice implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findById(username).orElseThrow(()->new UsernameNotFoundException("User not found with user name " + username));

        return new org.springframework.security.core.userdetails.User(user.getUserId(),user.getPassword(),getAuthority(user));
    }

    private HashSet<SimpleGrantedAuthority> getAuthority(User user) {
        HashSet<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ user.getRole()));
        return authorities;
    }
}