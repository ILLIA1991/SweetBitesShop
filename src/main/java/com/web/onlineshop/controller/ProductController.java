package com.web.onlineshop.controller;

import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Integer id) {
        return productService.getById(id);
    }
    @GetMapping
    public List<ProductDTO> getAll(){
        return productService.getAllProducts();
    }
    @PostMapping
    public Integer productCreate(@RequestBody ProductDTO productToCreate){
        return productService.createProduct(productToCreate);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.deleteById(id);
    }
    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Integer id, @RequestBody ProductDTO productToUpdate){
        return productService.updateProduct(id, productToUpdate);
    }
}


