package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.exception.OnlineShopNotFoundException;
import com.web.onlineshop.repository.ProductRepository;
import com.web.onlineshop.repository.mappers.ProductMapper;
import com.web.onlineshop.repository.model.Product;
import com.web.onlineshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

          return allProducts.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("Product not found: " + id));
        return productMapper.toProductDTO(product);

    }

    @Override
    public Integer createProduct(ProductDTO productsToCreate) {
        Product productToSave = productMapper.toProduct(productsToCreate);
        Product savedProduct = productRepository.save(productToSave);
        return savedProduct.getId();

    }

    @Override
    public void deleteById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("You are not with us anymore!: " + id));
        productRepository.delete(product);

    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productsToUpdate) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Product not found: " + id));
        productMapper.updateProductFromDTO(productsToUpdate, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toProductDTO(updatedProduct);
    }
}

