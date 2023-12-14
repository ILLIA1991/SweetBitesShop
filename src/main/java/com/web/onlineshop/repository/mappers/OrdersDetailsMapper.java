package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.OrderDetailsDTO;
import com.web.onlineshop.repository.model.Orders;
import com.web.onlineshop.repository.model.OrdersDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "string", uses = {OrderMapper.class})
public interface OrdersDetailsMapper {

    OrdersDetailsMapper INSTANCE = Mappers.getMapper(OrdersDetailsMapper.class);

    OrderDetailsDTO toOrderDetailsDTO(OrdersDetails ordersDetails);

    OrdersDetails toOrdersDetails(OrderDetailsDTO orderDetailsDTO);

    void updateOrdersDetailsFromDTO(OrderDetailsDTO orderDetailsToUpdate, @MappingTarget OrdersDetails existingOrdersDetails);

}