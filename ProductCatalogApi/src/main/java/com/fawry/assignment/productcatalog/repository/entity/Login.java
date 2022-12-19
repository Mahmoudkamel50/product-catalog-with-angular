package com.fawry.assignment.productcatalog.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String userName;

    private String password;

    @OneToOne
    private Customer customer;


}
