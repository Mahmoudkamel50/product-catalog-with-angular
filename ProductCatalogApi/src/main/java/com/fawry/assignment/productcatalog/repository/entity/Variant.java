package com.fawry.assignment.productcatalog.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "variant")
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "types")
    private String type;
    private int quantity;
    private double price;
    @Column(name = "buying_limit")
    private int limit;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_has_variants", joinColumns = @JoinColumn(name = "variant_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    @JsonIgnore
    private List<Order> orders;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;


}
