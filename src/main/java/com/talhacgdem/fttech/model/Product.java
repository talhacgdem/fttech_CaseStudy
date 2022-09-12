package com.talhacgdem.fttech.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Float price;

    @Column(nullable = true)
    private Date lastDate;

    @OneToMany
    private Set<ProductComment> productComments;
}
