package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
