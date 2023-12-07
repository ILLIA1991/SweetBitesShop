package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
