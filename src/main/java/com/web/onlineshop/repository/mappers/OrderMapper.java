package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.OrderDTO;
import com.web.onlineshop.repository.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "client", target = "clientDTO")
    OrderDTO toOrderDTO(Orders orders);

    @Mapping(source = "clientDTO", target = "client")
    Orders toOrders(OrderDTO orderDTO);

    @Mapping(source = "clientDTO", target = "client")
    void updateOrderFromDTO(OrderDTO orderToUpdate, @MappingTarget Orders existingOrder);
}

