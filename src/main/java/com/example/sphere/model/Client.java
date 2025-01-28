package com.example.sphere.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @ManyToOne
    private Product product;

    public Client() {
    }

    public Client(String name, String surname, Product product) {
        this.name = name;
        this.surname = surname;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
