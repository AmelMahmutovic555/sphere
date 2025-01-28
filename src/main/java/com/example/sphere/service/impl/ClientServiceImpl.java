package com.example.sphere.service.impl;

import com.example.sphere.model.Client;
import com.example.sphere.model.Product;
import com.example.sphere.repository.ClientRepository;
import com.example.sphere.repository.ProductRepository;
import com.example.sphere.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public ClientServiceImpl(ClientRepository clientRepository, ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return client;
    }

    @Override
    public Client save(String name, String surname, String productName, double price) {
        Product product = new Product(productName, price);
        productRepository.save(product);
        Client client = new Client(name, surname, product);
        return clientRepository.save(client);
    }

    @Override
    public Client edit(Long id, String name, String surname, String productName, double price) {
        Client client = clientRepository.findById(id).orElse(null);
        client.setName(name);
        client.setSurname(surname);
        client.getProduct().setName(productName);
        client.getProduct().setPrice(price);
        productRepository.save(client.getProduct());
        return clientRepository.save(client);
    }

    @Override
    public Client delete(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        clientRepository.delete(client);
        return client;
    }
}
