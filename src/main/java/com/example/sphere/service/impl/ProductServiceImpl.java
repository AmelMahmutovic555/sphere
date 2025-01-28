package com.example.sphere.service.impl;

import com.example.sphere.model.Product;
import com.example.sphere.repository.ProductRepository;
import com.example.sphere.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }
}
