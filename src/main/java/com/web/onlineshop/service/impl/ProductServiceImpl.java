package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.exception.OnlineShopNotFoundException;
import com.web.onlineshop.repository.ProductRepository;
import com.web.onlineshop.repository.mappers.ProductMapper;
import com.web.onlineshop.repository.model.Product;
import com.web.onlineshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



    /*
    @Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
      @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        return allProducts.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Integer id) {
        ProductDTO product = productRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("Product not found: " + id));
        return productMapper.map(product, ProductDTO.class);

    }

    @Override
    public Integer createProduct(ProductDTO productsToCreate) {
        Product productToSave = productMapper.toProduct(productsToCreate);
        Product savedProduct = productRepository.save(productToSave);
        return savedProduct.getId();

    }

    @Override
    public void deleteById(Integer id) {
        ProductDTO product = productRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("You are not with us anymore!: " + id));
        productRepository.delete(product);

    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productsToUpdate) {
        ProductDTO existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Product not found: " + id));
        productMapper.updateProductFromDTO(productsToUpdate, existingProduct);
        ProductDTO updatedProduct = productRepository.save(existingProduct);
        return productMapper.toProductDTO(updatedProduct);
    }
}

     */
