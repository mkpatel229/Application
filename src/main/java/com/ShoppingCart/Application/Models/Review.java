package com.ShoppingCart.Application.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @EmbeddedId
    private CompositeKey id;

    @ManyToOne
    @MapsId("customer_id")
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("review")
    Customer customer;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("review")
    Product product;

    double rating;

    String reviewComments;

}
