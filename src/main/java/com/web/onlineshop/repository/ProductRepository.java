package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query( value = "SELECT DISTINCT name FROM public.product\n" +
            "WHERE name like :letters", nativeQuery = true)
    List<String> findProductByFirstLetters(@Param("letters") String firstLetters);
}
