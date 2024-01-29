package com.web.onlineshop.service;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.repository.model.Role;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    ProductDTO createProduct(ProductDTO productCreate);
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProductById(Integer id);
    ProductDTO updateProduct(Integer id, ProductDTO updatedProduct);
    void deleteProduct(Integer id);

    // Управление пользователями
    ClientDTO assignRole(Integer id, Role newRole);

    ClientDTO blockClient(Integer id);

    ClientDTO unblockClient(Integer id);

    // Настройка параметров приложения
    String getSetting1();
    int getSetting2();
    void setSetting1(String value);
    void setSetting2(int value);

}
