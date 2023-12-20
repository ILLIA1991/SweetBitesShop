package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.OrderDTO;
import com.web.onlineshop.exception.OnlineShopNotFoundException;
import com.web.onlineshop.repository.OrderRepository;
import com.web.onlineshop.repository.mappers.OrderMapper;
import com.web.onlineshop.repository.model.Orders;
import com.web.onlineshop.service.OrderService;
import com.web.onlineshop.validator.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderValidator orderValidator;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, OrderValidator orderValidator) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderValidator = orderValidator;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Orders> allOrders = orderRepository.findAll();
        return allOrders.stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Integer id) {
        Orders order = orderRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Order not found: " + id));
        return orderMapper.toOrderDTO(order);
    }

    @Override
    public Integer createOrder(OrderDTO orderToCreate) {
        orderValidator.validateOrder(orderToCreate);
        Orders orderToSave = orderMapper.toOrders(orderToCreate);
        Orders savedOrder = orderRepository.save(orderToSave);
        return savedOrder.getId();
    }

    @Override
    public void deleteOrderById(Integer id) {
        Orders order = orderRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Order not found: " + id));
        orderRepository.delete(order);
    }

    @Override
    public OrderDTO updateOrder(Integer id, OrderDTO orderToUpdate) {
        orderValidator.validateOrder(orderToUpdate);
        Orders existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OnlineShopNotFoundException("Order not found: " + id));
        orderMapper.updateOrderFromDTO(orderToUpdate, existingOrder);
        Orders updatedOrder = orderRepository.save(existingOrder);
        return orderMapper.toOrderDTO(updatedOrder);
    }
}