package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByPhoneNumber(String phoneNumber);

    Client findByEmail(String email);
}
