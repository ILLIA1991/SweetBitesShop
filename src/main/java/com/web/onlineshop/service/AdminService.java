package com.web.onlineshop.service;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.repository.model.Role;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Integer createProduct(ProductDTO productCreate);

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(Integer id);

    ProductDTO updateProduct(Integer id, ProductDTO updatedProduct);

    void deleteProduct(Integer id);


    ClientDTO assignRole(Integer id, Role newRole);

    ClientDTO blockClient(Integer id);

    ClientDTO unblockClient(Integer id);


    int getMaxProductsPerPage();

    void setMaxProductsPerPage(int maxProductsPerPage);


    String getUserRoleAdmin();

    String getUserRoleClient();


    ClientDTO updateClient(Integer id, ClientDTO clientToUpdate);

    void deleteClientById(Integer id);

    List<ClientDTO> getAllClients();

    Integer createClient(ClientDTO clientToCreate);

    Optional<ClientDTO> getClientById(Integer id);
}
