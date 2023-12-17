package com.web.onlineshop.service;

import com.web.onlineshop.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getById(Integer id);

    @Transactional
    Integer createProduct(ProductDTO productsToCreate);

    void deleteById(Integer id);

    ProductDTO updateProduct(Integer id, ProductDTO productsToUpdate);
}
