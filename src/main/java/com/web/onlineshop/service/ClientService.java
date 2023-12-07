package com.web.onlineshop.service;

import com.web.onlineshop.dto.ClientDTO;

import java.util.List;


public interface ClientService {

    List<ClientDTO> getAllClients();

    ClientDTO getById(Integer id);

    Integer createClient(ClientDTO clientDTO);

    void deleteById(Integer id);

    ClientDTO updateClient(Integer id, ClientDTO clientsToUpdate);
}
