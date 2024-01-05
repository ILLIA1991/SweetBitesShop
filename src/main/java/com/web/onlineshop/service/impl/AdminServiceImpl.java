package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.repository.model.Role;
import com.web.onlineshop.service.AdminService;
import com.web.onlineshop.service.ClientService;
import com.web.onlineshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {
    private ProductService productService;
    private ClientService clientService;
    private
    @Override
    public ProductDTO createProduct(ProductDTO productCreate) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public Optional<ProductDTO> getProductById(Integer id) {
        return Optional.empty();
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO updatedProduct) {
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {

    }

    @Override
    public ClientDTO assignRole(Integer id, Role newRole) {
        return null;
    }

    @Override
    public ClientDTO blockClient(Integer id) {
        return null;
    }

    @Override
    public ClientDTO unblockClient(Integer id) {
        return null;
    }

    @Override
    public String getSetting1() {
        return null;
    }

    @Override
    public int getSetting2() {
        return 0;
    }

    @Override
    public void setSetting1(String value) {

    }

    @Override
    public void setSetting2(int value) {

    }
}
