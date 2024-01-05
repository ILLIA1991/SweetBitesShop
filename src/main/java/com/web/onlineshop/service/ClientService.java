package com.web.onlineshop.service;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.repository.model.Role;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getAllClients();

    ClientDTO getById(Integer id);

    Integer createClient(ClientDTO clientDTO);

    void deleteById(Integer id);

    ClientDTO updateClient(Integer id, ClientDTO clientsToUpdate);

    ClientDTO assignRole(Integer id, Role newRole);

    ClientDTO blockClient(Integer id);

    ClientDTO unblockClient(Integer id);
}
