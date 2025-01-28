package com.example.sphere.repository;

import com.example.sphere.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
    Optional<UserInformation> findByEmailAndPassword(String email, String password);
    Optional<UserInformation> findByEmail(String email);
}
