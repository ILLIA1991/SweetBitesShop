package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByPhoneNumber(String phoneNumber);

    Client findByEmail(String email);
}
