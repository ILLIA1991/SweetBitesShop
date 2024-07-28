package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.exception.OnlineShopNotFoundException;
import com.web.onlineshop.repository.ClientRepository;
import com.web.onlineshop.repository.ProductRepository;
import com.web.onlineshop.repository.mappers.ClientMapper;
import com.web.onlineshop.repository.mappers.ProductMapper;
import com.web.onlineshop.repository.model.Client;
import com.web.onlineshop.repository.model.Product;
import com.web.onlineshop.repository.model.Role;
import com.web.onlineshop.service.AdminService;
import com.web.onlineshop.validator.ClientValidator;
import com.web.onlineshop.validator.ProductValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    private final ClientValidator clientValidator;
    private final ProductValidator productValidator;

    private int maxProductsPerPage = 10;

    public AdminServiceImpl(ProductRepository productRepository, ClientRepository clientRepository, ClientValidator clientValidator, ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.clientValidator = clientValidator;
        this.productValidator = productValidator;
    }

    @Override
    @Transactional
    public Integer createProduct(ProductDTO productCreate) {
        productValidator.validateProduct(productCreate);
        ProductMapper productMapper = ProductMapper.INSTANCE; // Создаем экземпляр ProductMapper
        Product productToSave = productMapper.toProduct(productCreate); // Вызываем метод toProduct на созданном экземпляре
        Product savedProduct = productRepository.save(productToSave);
        return savedProduct.getId();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .map(ProductMapper.INSTANCE::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(Integer id) {
        return productRepository.findById(id).map(ProductMapper.INSTANCE::toProductDTO);
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(Integer id, ProductDTO updatedProduct) {
        productValidator.validateProduct(updatedProduct);
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Product not found: " + id));
        ProductMapper.INSTANCE.updateProductFromDTO(updatedProduct, existingProduct);
        Product updatedProductEntity = productRepository.save(existingProduct);
        return ProductMapper.INSTANCE.toProductDTO(updatedProductEntity);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Product not found: " + id));
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public ClientDTO assignRole(Integer id, Role newRole) {
        clientValidator.validateRole(newRole);
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setRole(newRole);
            Client updatedClient = clientRepository.save(client);
            return ClientMapper.INSTANCE.toClientDTO(updatedClient);
        } else {
            throw new OnlineShopNotFoundException("Client not found: " + id);
        }
    }

    @Override
    @Transactional
    public ClientDTO blockClient(Integer id) {
        return updateClientStatus(id, true);
    }

    @Override
    @Transactional
    public ClientDTO unblockClient(Integer id) {
        return updateClientStatus(id, false);
    }

    private ClientDTO updateClientStatus(Integer id, boolean blocked) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setBlocked(blocked);
            Client updatedClient = clientRepository.save(client);
            return ClientMapper.INSTANCE.toClientDTO(updatedClient);
        } else {
            throw new OnlineShopNotFoundException("Client not found: " + id);
        }
    }


    @Override
    public int getMaxProductsPerPage() {
        return maxProductsPerPage;
    }

    @Override
    public void setMaxProductsPerPage(int maxProductsPerPage) {
        this.maxProductsPerPage = maxProductsPerPage;
    }

    @Override
    public String getUserRoleAdmin() {
        return "ADMIN";
    }

    @Override
    public String getUserRoleClient() {
        return "CLIENT";
    }


    @Override
    @Transactional
    public ClientDTO updateClient(Integer id, ClientDTO clientToUpdate) {
        clientValidator.validateClient(clientToUpdate);
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Client not found: " + id));
        ClientMapper.INSTANCE.updateClientFromDTO(clientToUpdate, existingClient);
        Client updatedClient = clientRepository.save(existingClient);
        return ClientMapper.INSTANCE.toClientDTO(updatedClient);
    }

    @Override
    @Transactional
    public void deleteClientById(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Client not found: " + id));
        clientRepository.delete(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> allClients = clientRepository.findAll();
        return allClients.stream()
                .map(ClientMapper.INSTANCE::toClientDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Integer createClient(ClientDTO clientToCreate) {
        clientValidator.validateClient(clientToCreate);
        Client clientToSave = ClientMapper.INSTANCE.toClient(clientToCreate);
        Client savedClient = clientRepository.save(clientToSave);
        return savedClient.getId();
    }


    @Override
    public Optional<ClientDTO> getClientById(Integer id) {
        return Optional.empty();
    }
}




