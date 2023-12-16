package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.FlavourCategoryDTO;
import com.web.onlineshop.repository.model.FlavourCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlavourCategoryMapper {

    FlavourCategoryMapper INSTANCE = Mappers.getMapper(FlavourCategoryMapper.class);

    FlavourCategoryDTO toFlavourCategoryDTO(FlavourCategory flavourCategory);

    FlavourCategory toFlavourCategory(FlavourCategoryDTO flavourCategoryDTO);

    void updateFlavourFromDTO(FlavourCategoryDTO flavourCategoryDTO, @MappingTarget FlavourCategory existingFlavoursCategory);
}
