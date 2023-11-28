package com.web.onlineshop.repository;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.repository.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
