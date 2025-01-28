package com.example.sphere.service;

import com.example.sphere.model.Client;
import com.example.sphere.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAll();
    Product findById(Long id);
}
