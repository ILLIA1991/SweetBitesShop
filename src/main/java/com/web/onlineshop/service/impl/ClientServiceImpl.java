package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.repository.ClientRepository;
import com.web.onlineshop.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public List<ClientDTO> getAllClients() {
        List<ClientDTO> allClients = clientRepository.findAll();
        return allClients;
    }

    @Override
    public ClientDTO getById(Integer id) {
        return null;
    }

    @Override
    public Integer createClient(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public ClientDTO updateClient(Integer id, ClientDTO clientsToUpdate) {
        return null;
    }
}
