package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.repository.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    // Методы для преобразования между Entity и DTO
    ClientDTO toClientDTO(Client client);
    Client toClient(ClientDTO clientDTO);

    //ClientDTO map(Client client, Class<ClientDTO> clientDTOClass);

    void updateClientFromDTO(ClientDTO clientDTO, @MappingTarget Client client);


}
