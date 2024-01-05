package com.web.onlineshop.controller;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.repository.model.Role;
import com.web.onlineshop.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Client management API", description = "API for CRUD operations with clients")
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(description = "In case the client is not found, the response will have a status of 404")
    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable Integer id) {
        return clientService.getById(id);
    }

    @Operation(description = "In case no client is found, the response will have a status of 404")
    @GetMapping
    public List<ClientDTO> getAll() {
        return clientService.getAllClients();
    }


    @Operation(description = "In case the client is not created, the response will have a status of 404")
    @PostMapping
    public Integer createUser(@RequestBody ClientDTO clientToCreate) {
        return clientService.createClient(clientToCreate);
    }

    @Operation(description = "In case the client is not deleted by ID, the response will have a status of 404")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.deleteById(id);
    }

    @Operation(description = "In case the client is not updated correctly by ID, the response will have a status of 404")
    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Integer id, @RequestBody ClientDTO clientToUpdate) {
        return clientService.updateClient(id, clientToUpdate);
    }

    @PostMapping("/{clientId}/assign-role")
    public ResponseEntity<ClientDTO> assignRole(@PathVariable Integer clientId, @RequestParam Role newRole) {
        ClientDTO client = clientService.assignRole(clientId, newRole);
        return client != null
                ? ResponseEntity.ok(client)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/{clientId}/block")
    public ResponseEntity<ClientDTO> blockClient(@PathVariable Integer clientId) {
        ClientDTO client = clientService.blockClient(clientId);
        return client != null
                ? ResponseEntity.ok(client)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/{clientId}/unblock")
    public ResponseEntity<ClientDTO> unblockClient(@PathVariable Integer clientId) {
        ClientDTO client = clientService.unblockClient(clientId);
        return client != null
                ? ResponseEntity.ok(client)
                : ResponseEntity.notFound().build();
    }
}