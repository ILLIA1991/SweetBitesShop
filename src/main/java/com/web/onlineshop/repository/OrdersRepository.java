package com.web.onlineshop.repository;

import com.web.onlineshop.dto.OrdersDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersDTO, Integer> {
}
