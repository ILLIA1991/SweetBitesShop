package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.repository.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {FlavourCategoryMapper.class})
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "flavourCategory", target = "flavourCategoryDTO")
    ProductDTO toProductDTO(Product product);

    @Mapping(source = "flavourCategoryDTO", target = "flavourCategory")
    Product toProduct(ProductDTO productDTO);

    @Mapping(source = "flavourCategoryDTO", target = "flavourCategory")
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);
}