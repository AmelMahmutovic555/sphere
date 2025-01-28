package com.example.sphere.service;

import com.example.sphere.model.UserInformation;

public interface UserInformationService {
    UserInformation registerInformartion(String firstName, String lastName, String email, String password);
    UserInformation loginInformation(String email, String password);

}
