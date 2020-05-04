package com.ShoppingCart.Application.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue
    Integer productId;

    @Column(nullable = false)
    String name;

    @Column(nullable = true)
    String shortDesc;

    @Column(nullable = true)
    String description;

    @Column(nullable = true)
    String category;

    @Column(columnDefinition = "double precision default 0")
    double price = 0;

    @Column(columnDefinition = "double precision default 0")
    double discount = 0;

    @Column(columnDefinition = "double precision default 0")
    double deliveryCharge = 0;

    @Column(columnDefinition = "double precision default 0")
    double offerPrice = price*discount/100;

    @Column(nullable = true)
    String seller;

    @Column(columnDefinition = "double precision default 0")
    double avgRating = 0;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    List<Review> review;
}
