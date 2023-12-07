package com.web.onlineshop.service;

import com.web.onlineshop.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Integer id);

    Integer createOrder(OrderDTO orderDTO);

    void deleteOrderById(Integer id);

    OrderDTO updateOrder(Integer id, OrderDTO orderToUpdate);
}

