package com.web.onlineshop.controller;

import com.web.onlineshop.dto.ClientDTO;
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

    @Operation(description = "Get a client by ID. If the client is not found, the response will have a status of 404")
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Integer id) {
        Optional<ClientDTO> client = adminService.getClientById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
}
