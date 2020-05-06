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

    @Column(columnDefinition = "varchar(255) default 'USER'")
    String role = "USER";

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.role = "USER";
    }
}
