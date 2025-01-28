package com.example.sphere.service.impl;

import com.example.sphere.model.UserInformation;
import com.example.sphere.repository.UserInformationRepository;
import com.example.sphere.service.UserInformationService;
import lombok.val;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    private final UserInformationRepository userInformationRepository;

    public UserInformationServiceImpl(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }

    @Override
    public UserInformation registerInformartion(String firstName, String lastName, String email, String password) {
        UserInformation userInformation = new UserInformation(firstName, lastName, email, password);
        return userInformationRepository.save(userInformation);
    }

    @Override
    public UserInformation loginInformation(String email, String password) {
        if (email == null && email.isEmpty() || password == null && password.isEmpty()){
            return null;
        }
        return userInformationRepository.findByEmailAndPassword(email, password).orElse(null);
    }
}
