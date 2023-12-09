package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDetailsRepository extends JpaRepository<OrdersDetails, Integer> {
}
