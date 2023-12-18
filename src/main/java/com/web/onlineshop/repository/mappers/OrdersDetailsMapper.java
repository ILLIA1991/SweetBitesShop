package com.web.onlineshop.repository.mappers;

import com.web.onlineshop.dto.OrderDetailsDTO;

import com.web.onlineshop.repository.model.OrdersDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "string", uses = {OrderMapper.class})
public interface OrdersDetailsMapper {

    OrdersDetailsMapper INSTANCE = Mappers.getMapper(OrdersDetailsMapper.class);

    default OrderDetailsDTO toOrderDetailsDTO(OrdersDetails ordersDetails) {
        return null;
    }

    default OrdersDetails toOrdersDetails(OrderDetailsDTO orderDetailsDTO) {
        return null;
    }

    void updateOrdersDetailsFromDTO(OrderDetailsDTO orderDetailsToUpdate, @MappingTarget OrdersDetails existingOrdersDetails);

}
