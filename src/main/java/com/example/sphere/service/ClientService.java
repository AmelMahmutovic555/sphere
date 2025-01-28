package com.example.sphere.service;

import com.example.sphere.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> listAll();
    Client findById(Long id);
    Client save(String name, String surname, String productName, double price);
    Client edit(Long id, String name, String surname, String productName, double price);
    Client delete(Long id);
}
