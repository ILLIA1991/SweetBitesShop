package com.web.onlineshop.controller;

import com.web.onlineshop.dto.OrderDTO;
import com.web.onlineshop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAll() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Integer createOrder(@RequestBody OrderDTO orderToCreate) {
        return orderService.createOrder(orderToCreate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
    }

    @PutMapping("/{id}")
    public OrderDTO update(@PathVariable Integer id, @RequestBody OrderDTO orderToUpdate) {
        return orderService.updateOrder(id, orderToUpdate);
    }
}
