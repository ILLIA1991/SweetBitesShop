package com.web.onlineshop.controller;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.repository.model.Role;
import com.web.onlineshop.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Operation(description = "Get all clients")
    @GetMapping
    public List<ClientDTO> getAllClients() {
    return adminService.getAllClients();
    }

    @Operation(description = "Create a new client. If the client is not created, the response will have a status of 404")
    @PostMapping
    public ResponseEntity<Integer> createClient(@RequestBody ClientDTO clientToCreate) {
        Integer clientId = adminService.createClient(clientToCreate);
        return clientId != null
                ? ResponseEntity.ok(clientId)
                : ResponseEntity.notFound().build();
    }

    @Operation(description = "Delete a client by ID. If the client is not deleted, the response will have a status of 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        adminService.deleteClientById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(description = "Update a client by ID. If the client is not updated, the response will have a status of 404")
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Integer id, @RequestBody ClientDTO clientToUpdate) {
        ClientDTO updatedClient = adminService.updateClient(id, clientToUpdate);
        return updatedClient != null
                ? ResponseEntity.ok(updatedClient)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/products")
    public ResponseEntity<Integer> createProduct(@RequestBody ProductDTO productCreate) {
        Integer productId = adminService.createProduct(productCreate);
        return ResponseEntity.ok(productId);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = adminService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        Optional<ProductDTO> product = adminService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO updateProduct) {
        ProductDTO product = adminService.updateProduct(id, updateProduct);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        adminService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/maxProductsPerPage")
    public ResponseEntity<Integer> getMaxProductsPerPage() {
        int maxProductsPerPage = adminService.getMaxProductsPerPage();
        return ResponseEntity.ok(maxProductsPerPage);
    }

    @PutMapping("/maxProductsPerPage")
    public ResponseEntity<Void> setMaxProductsPerPage(@RequestParam("maxProductsPerPage") int maxProductsPerPage) {
        adminService.setMaxProductsPerPage(maxProductsPerPage);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/userRoleAdmin")
    public ResponseEntity<String> getUserRoleAdmin() {
        String userRoleAdmin = adminService.getUserRoleAdmin();
        return ResponseEntity.ok(userRoleAdmin);
    }

    @GetMapping("/userRoleClient")
    public ResponseEntity<String> grtUserRoleClient() {
        String userRoleClient = adminService.getUserRoleClient();
        return ResponseEntity.ok(userRoleClient);
    }

    @PostMapping("/clients/{id}/assignRole")
    public ResponseEntity<ClientDTO> assignRole(@PathVariable Integer id, @RequestBody Role newRole) {
        ClientDTO updateClient = adminService.assignRole(id, newRole);
        return ResponseEntity.ok(updateClient);
    }
    
    @PostMapping("/clients/{id}/block")
    public ResponseEntity<ClientDTO> block(@PathVariable Integer id) {
        ClientDTO updateClient = adminService.blockClient(id);
        return ResponseEntity.ok(updateClient);
    }
    
    @PostMapping("/clients/{id}/unblock")
    public ResponseEntity<ClientDTO> unblock(@PathVariable Integer id) {
        ClientDTO updateClient = adminService.unblockClient(id);
        return ResponseEntity.ok(updateClient);
    }
}
