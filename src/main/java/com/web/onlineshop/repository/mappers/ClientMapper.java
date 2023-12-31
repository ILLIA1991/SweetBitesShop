package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.repository.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toClientDTO(Client client);

    Client toClient(ClientDTO clientDTO);

    void updateClientFromDTO(ClientDTO clientDTO, @MappingTarget Client client);
}
