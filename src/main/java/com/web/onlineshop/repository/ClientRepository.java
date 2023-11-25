package com.web.onlineshop.repository;

import com.web.onlineshop.dto.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientDTO, Integer> {
}
