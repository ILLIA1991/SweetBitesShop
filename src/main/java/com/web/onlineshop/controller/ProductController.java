package com.web.onlineshop.controller;

import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product Management API", description = "API for CRUD operations with products")
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Tag(name = "Fetching a product by ID", description = "In case the product is not found, the response will have a status of 404")
    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @Tag(name = "Retrieving all products", description = "In case no product is found, the response will have a status of 404")
    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAllProducts();
    }


    @Tag(name = "Creating a new product", description = "In case the product is not created, the response will have a status of 404")
    @PostMapping
    public Integer productCreate(@RequestBody ProductDTO productToCreate) {
        return productService.createProduct(productToCreate);
    }

    @Tag(name = "Delete a product by ID", description = "In case the product is not deleted by ID, the response will have a status of 404")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @Tag(name = "Updating a product by ID", description = "In case the product is not updated correctly by ID, the response will have a status of 404")
    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Integer id, @RequestBody ProductDTO productToUpdate) {
        return productService.updateProduct(id, productToUpdate);
    }

    @Tag(name = "Fetching a product by first letters", description = "In case the product is not found, the response will have an empty list")
    @GetMapping("/search/firstLetters")
    public List<String> getByFirstLetters(@RequestParam String letters) {
        return productService.findProductsByFirstLetters(letters);
    }
}
