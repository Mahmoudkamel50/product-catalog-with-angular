package com.fawry.assignment.productcatalog.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "is_bought")
    private boolean isBought;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<Variant> variants;

}
