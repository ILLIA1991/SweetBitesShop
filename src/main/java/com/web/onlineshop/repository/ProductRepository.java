package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query( value = "SELECT DISTINCT * FROM public.product\n" +
            "WHERE name like :letters", nativeQuery = true)
    List<Product> findProductByFirstLetters(@Param("letters") String firstLetters);

    @Query("SELECT p FROM Product p WHERE UPPER(p.flavourCategory.name) LIKE UPPER(:flavour)")
    List<Product> findProductsByFlavour(@Param("flavour") String flavour);
}
