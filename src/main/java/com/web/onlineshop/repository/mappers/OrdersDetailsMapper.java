package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.OrderDetailsDTO;
import com.web.onlineshop.repository.model.OrdersDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OrderMapper.class, ProductMapper.class})
public interface OrdersDetailsMapper {
    OrdersDetailsMapper INSTANCE = Mappers.getMapper(OrdersDetailsMapper.class);

    @Mapping(target = "ordersDTO", source = "orders")
    @Mapping(target = "productDTO", source = "product")
    OrderDetailsDTO toOrderDetailsDTO(OrdersDetails ordersDetails);

}
