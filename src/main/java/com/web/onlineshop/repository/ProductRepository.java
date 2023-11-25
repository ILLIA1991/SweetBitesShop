package com.web.onlineshop.repository;

import com.web.onlineshop.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDTO, Integer> {


}
