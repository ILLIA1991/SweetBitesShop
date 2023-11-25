package com.web.onlineshop.repository;

import com.web.onlineshop.dto.OrdersDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrdersDetailsDTO, Integer> {
}
