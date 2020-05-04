package com.ShoppingCart.Application.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @Column(name = "user_id")
    String userId;

    String password;

//    @OneToOne
//    @JoinColumn(name = "id")
//    @MapsId
//    Customer customer;

}
