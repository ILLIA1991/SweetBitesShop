package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.exception.OnlineShopNotFoundException;
import com.web.onlineshop.repository.ClientRepository;
import com.web.onlineshop.repository.mappers.ClientMapper;
import com.web.onlineshop.repository.model.Client;
import com.web.onlineshop.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.onlineshop.validator.ClientValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientValidator clientValidator;
    private static final String CLIENT_NOT_FOUND_MESSAGE = "Client not found: ";


    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper, ClientValidator clientValidator) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.clientValidator = clientValidator;
    }

    /**
     * Получить всех клиентов.
     *
     * @return список клиентов
     */
    @Override
    public List<ClientDTO> getAllClients() {
        // Извлекаем всех клиентов из репозитория (предположим, что они в формате Client)
        List<Client> allClients = clientRepository.findAll();

        // Применяем маппер к каждому клиенту
        return allClients.stream()
                .map(clientMapper::toClientDTO)
                .collect(Collectors.toList());
    }

    /**
     * Получить клиента по идентификатору.
     *
     * @param id идентификатор клиента
     * @return клиент
     * @throws OnlineShopNotFoundException если клиент не найден
     */
    @Override
    public ClientDTO getById(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException(CLIENT_NOT_FOUND_MESSAGE + id));
        return clientMapper.toClientDTO(client);
    }

    /**
     * Создать нового клиента.
     *
     * @param clientsToCreate данные нового клиента
     * @return идентификатор созданного клиента
     */

    @Override
    @Transactional
    public Integer createClient(ClientDTO clientsToCreate) {
        Client clientToSave = clientMapper.toClient(clientsToCreate);
        Client savedClient = clientRepository.save(clientToSave);
        clientValidator.validateClient(clientsToCreate);
        return savedClient.getId();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("You are not with us anymore!: " + id));
        clientRepository.delete(client);

    }

    @Override
    @Transactional
    public ClientDTO updateClient(Integer id, ClientDTO clientsToUpdate) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException(CLIENT_NOT_FOUND_MESSAGE + id));
        clientValidator.validateClient(clientsToUpdate);
        clientMapper.updateClientFromDTO(clientsToUpdate, existingClient);
        Client updatedClient = clientRepository.save(existingClient);
        return clientMapper.toClientDTO(updatedClient);

    }
}
