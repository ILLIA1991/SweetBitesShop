package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.repository.FlavourCategoryRepository;
import com.web.onlineshop.repository.ProductRepository;
import com.web.onlineshop.repository.mappers.ProductMapper;
import com.web.onlineshop.repository.model.Product;
import com.web.onlineshop.service.ProductService;
import com.web.onlineshop.validator.ProductValidator;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {
    private final ProductRepository productRepository = mock(ProductRepository.class);
    private final FlavourCategoryRepository flavourCategoryRepository = mock(FlavourCategoryRepository.class);
    private final ProductValidator productValidator = mock(ProductValidator.class);
    private final ProductMapper productMapper = mock(ProductMapper.class);
    private final ProductService target = new ProductServiceImpl(productRepository, flavourCategoryRepository, productValidator, productMapper);

    @Test
    void shouldCreateProduct() {
        //given
        ProductDTO productDTO = new ProductDTO();
        Product productToSave = new Product();
        Product savedProduct = new Product();

        when(ProductMapper.toProduct(productDTO)).thenReturn(productToSave);
        when(productRepository.save(productToSave)).thenReturn(savedProduct);

        //when
        Integer actualId = target.createProduct(productDTO);

        //then
        verify(productValidator).validateProduct(productDTO);
        ProductMapper.toProduct(productDTO); // Исправление: Добавлен вызов метода toProduct()
        assertThat(actualId).isEqualTo(savedProduct.getId());
    }


    @Test
    void shouldUpdateProduct() {
        // given
        Integer productId = 7;
        ProductDTO updatedProductDTO = new ProductDTO();
        Product existingProduct = new Product();
        Product updatedProduct = new Product();

        when(ProductMapper.toProduct(updatedProductDTO)).thenReturn(existingProduct);
        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);
        when(productMapper.toProductDTO(updatedProduct)).thenReturn(updatedProductDTO);

        // when
        ProductDTO actualProductDTO = target.updateProduct(productId, updatedProductDTO);

        // then
        verify(productValidator).validateProduct(updatedProductDTO);
        verify(productRepository).findById(productId);
        verify(productMapper);
        ProductMapper.toProduct(updatedProductDTO);
        verify(productMapper).toProductDTO(updatedProduct);

        assertThat(actualProductDTO.getId()).isEqualTo(updatedProduct.getId());
    }

    @Test
    void shouldGetProductById() {
        // given
        Integer productId = 18;
        Product productToReturn = new Product();
        ProductDTO savedProductDTO = new ProductDTO();

        when(productRepository.findById(productId)).thenReturn(Optional.of(productToReturn));
        when(productMapper.toProductDTO(productToReturn)).thenReturn(savedProductDTO);

        // when
        ProductDTO actualProductDTO = target.getById(productId);

        // then
        verify(productRepository).findById(productId);
        verify(productMapper).toProductDTO(productToReturn);

        assertThat(actualProductDTO).isEqualTo(savedProductDTO);
    }

    @Test
    void shouldGetAllProducts() {
        // given
        List<Product> products = Arrays.asList(new Product(), new Product());
        List<ProductDTO> savedProductDTOs = Arrays.asList(new ProductDTO(), new ProductDTO());

        when(productRepository.findAll()).thenReturn(products);
        when(productMapper.toProductDTO((Product) products)).thenReturn((ProductDTO) savedProductDTOs);

        // when
        List<ProductDTO> actualProductDTOs = target.getAllProducts();

        // then
        verify(productRepository).findAll();
        verify(productMapper).toProductDTO((Product) products);

        assertThat(actualProductDTOs).isEqualTo(savedProductDTOs);
    }
}
