package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.OrderDTO;
import com.web.onlineshop.repository.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toOrderDTO(Orders orders);

    Orders toOrders(OrderDTO orderDTO);

    void updateOrderFromDTO(OrderDTO orderToUpdate, @MappingTarget Orders existingOrder);
}
