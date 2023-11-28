package com.web.onlineshop.service;

import com.web.onlineshop.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();


    ProductDTO getById(Integer id);

    Integer createProduct(ProductDTO productDTO);

    void deleteById(Integer id);

    ProductDTO updateProduct(Integer id, ProductDTO productsToUpdate);
}
