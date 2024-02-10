package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.exception.OnlineShopNotFoundException;
import com.web.onlineshop.repository.FlavourCategoryRepository;
import com.web.onlineshop.repository.ProductRepository;
import com.web.onlineshop.repository.mappers.ProductMapper;
import com.web.onlineshop.repository.model.Product;
import com.web.onlineshop.service.ProductService;
import com.web.onlineshop.validator.ProductValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final FlavourCategoryRepository flavourCategoryRepository;
    private final ProductValidator productValidator;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, FlavourCategoryRepository flavourCategoryRepository, ProductValidator productValidator, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.flavourCategoryRepository = flavourCategoryRepository;
        this.productValidator = productValidator;
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
    @Transactional
    public Integer createProduct(ProductDTO productsToCreate) {
        productValidator.validateProduct(productsToCreate);
        Product productToSave = ProductMapper.toProduct(productsToCreate);
        Product savedProduct = productRepository.save(productToSave);
        return savedProduct.getId();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("You are not with us anymore!: " + id));
        productRepository.delete(product);

    }

    @Override
    @Transactional
    public ProductDTO updateProduct(Integer id, ProductDTO productsToUpdate) {
        productValidator.validateProduct(productsToUpdate);
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Product not found: " + id));
        productMapper.updateProductFromDTO(productsToUpdate, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toProductDTO(updatedProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findProductsByFirstLetters(String letters) {
        return productRepository.findProductByFirstLetters(
             letters.substring(0, 1).toUpperCase() + letters.substring(1).toLowerCase() + "%")
                .stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }
    public List<ProductDTO> getAllProductsSortedByPriceAsc(BigDecimal page, BigDecimal size) {
        if (size.compareTo(BigDecimal.ONE) < 0) {
            throw new IllegalArgumentException("Page size must not be less than one");
        }

        List<Product> productList = productRepository.findAll(PageRequest.of(page.intValue(), size.intValue(), Sort.by(Sort.Direction.ASC, "price"))).getContent();

        return productList.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsSortedByPriceDesc(BigDecimal page, BigDecimal size) {
        if (size.compareTo(BigDecimal.ONE) < 0) {
            throw new IllegalArgumentException("Page size must not be less than one");
        }

        List<Product> productList = productRepository.findAll(PageRequest.of(page.intValue(), size.intValue(), Sort.by(Sort.Direction.DESC, "price"))).getContent();

        return productList.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<ProductDTO> findProductsByFlavour(String flavour) {
        List<Product> productList = productRepository.findProductsByFlavour(flavour);
        return productList.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }
}

