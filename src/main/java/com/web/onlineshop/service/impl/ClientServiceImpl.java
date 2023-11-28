package com.web.onlineshop.service.impl;
import com.web.onlineshop.repository.model.Client;
import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.exception.OnlineShopNotFoundException;
import com.web.onlineshop.repository.ClientRepository;
import com.web.onlineshop.repository.mappers.ClientMapper;
import com.web.onlineshop.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

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
        List<ClientDTO> allClientDTOs = allClients.stream()
                .map(clientMapper::toClientDTO)
                .collect(Collectors.toList());
        return allClientDTOs;
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
        Client client = clientRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("Client not found: " + id));
        return clientMapper.map(client, ClientDTO.class);
    }

    /**
     * Создать нового клиента.
     *
     * @param clientsToCreate данные нового клиента
     * @return идентификатор созданного клиента
     */

    @Override
    public Integer createClient(ClientDTO clientsToCreate) {
        Client clientToSave = clientMapper.toClient(clientsToCreate) ;
        // Сохраняю нового клиента в репозитории
        Client savedClient = clientRepository.save(clientToSave);
        // Возвращаю идентификатор созданного клиента
        return savedClient.getId();
    }

    @Override
    public void deleteById(Integer id) {
        //поскольку я просто удаляю клиента по идентификатору, нет необходимости в использовать MapStruct
        Client client = clientRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("You are not with us anymore!: " + id));
        clientRepository.delete(client);

    }

    @Override
    public ClientDTO updateClient(Integer id, ClientDTO clientsToUpdate) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Client not found: " + id));

        // Применяю маппер для обновления полей
        clientMapper.updateClientFromDTO(clientsToUpdate, existingClient);

        // Сохраняю обновленного клиента в репозитории
        Client updatedClient = clientRepository.save(existingClient);

        // Возвращаю обновленного клиента в виде DTO
        return clientMapper.toClientDTO(updatedClient);

    }
}
