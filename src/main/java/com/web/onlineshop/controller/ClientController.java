package com.web.onlineshop.controller;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.service.ClientService;


import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

//@Tag(name = "Client management API", description = "API for CRUD operations with clients")
@RestController
@RequestMapping("/users")
public class ClientController {

    //private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping
    public List<ClientDTO> getAll() {
        return clientService.getAllClients();
    }
    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable Integer id) {
        return clientService.getById(id);
    }
    @PostMapping
    public Integer createUser(@RequestBody ClientDTO clientsToCreate) {
        return clientService.createClient(clientsToCreate);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.deleteById(id);
    }
    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Integer id, @RequestBody ClientDTO clientsToUpdate) {
        return clientService.updateClient(id, clientsToUpdate);
    }
}
