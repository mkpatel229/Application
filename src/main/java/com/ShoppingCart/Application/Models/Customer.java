package com.ShoppingCart.Application.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    Integer customerId;

    @Column(nullable = false)
    String name;

    @Column(nullable = true)
    String gender;

    @Column(nullable = true)
    Date dob;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("customer")
    List<Review> review;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

}
