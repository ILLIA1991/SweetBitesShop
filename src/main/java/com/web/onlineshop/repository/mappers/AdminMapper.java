package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.AdminDTO;
import com.web.onlineshop.repository.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDTO toAdminDTO(Admin admin);

    Admin toAdmin(AdminDTO adminDTO);

    void updateAdminFromDTO(AdminDTO adminDTO, @MappingTarget Admin admin);
}
