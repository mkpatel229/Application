package com.ShoppingCart.Application.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class CompositeKey implements Serializable {

    @Column(name = "product_id")
    Integer productId;
    @Column(name = "customer_id")
    Integer userId;
}
