package com.example.sphere.config;

import com.example.sphere.model.Client;
import com.example.sphere.model.Product;
import com.example.sphere.repository.ClientRepository;
import com.example.sphere.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    public static List<Client> clients = new ArrayList<>();

    public DataInit(ClientRepository clientRepository, ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init(){
        String[] nizaIme = {"Amel", "Ivona", "Aleksandar", "Igor", "Jovana", "Petar", "Simona", "Melisa", "Atanas", "Anastasija"};
        String[] nizaPrezime = {"Mahmutovic", "Ivanovska", "Gligorovski", "Sarinski", "Jovanovska", "Petrovski", "Simonovska", "Simic", "Atanasovski", "Mievska"};

        int j = 1;
        for (int i = 0; i < 10; i++){
            clients.add(new Client(nizaIme[i], nizaPrezime[i], productRepository.save(new Product("Product: ", j * 2.25))));
            j++;
        }

        clientRepository.saveAll(clients);

    }
}
