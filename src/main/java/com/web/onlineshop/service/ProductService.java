package com.web.onlineshop.service;

import com.web.onlineshop.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getById(Integer id);

    Integer createProduct(ProductDTO productsToCreate);

    void deleteById(Integer id);

    ProductDTO updateProduct(Integer id, ProductDTO productsToUpdate);

    List<ProductDTO> findProductsByFirstLetters(String firstLetters);

    List<ProductDTO> getAllProductsSortedByPriceAsc(BigDecimal page, BigDecimal size);

    List<ProductDTO> getAllProductsSortedByPriceDesc(BigDecimal page, BigDecimal size);

    List<ProductDTO> findProductsByFlavour(String flavour);
}
