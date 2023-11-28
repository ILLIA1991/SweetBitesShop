package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.repository.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDTO(ProductDTO product);

    Product toProduct(ProductDTO productDTO);

    ProductDTO map(ProductDTO product, Class<ProductDTO> productDTOClass);

    @Mapping(target = "id", ignore = true)
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget ProductDTO product);
}
