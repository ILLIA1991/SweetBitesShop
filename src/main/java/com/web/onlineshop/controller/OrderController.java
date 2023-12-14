package com.web.onlineshop.controller;

import com.web.onlineshop.dto.OrderDTO;
import com.web.onlineshop.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Order Management API", description = "API for CRUD operations with orders")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Tag(name = "Retrieving all orders", description = "In case no order is found, the response will have a status of 404")
    @GetMapping
    public List<OrderDTO> getAll() {
        return orderService.getAllOrders();
    }

    @Tag(name = "Fetching an order by ID", description = "In case the order is not found, the response will have a status of 404")
    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @Tag(name = "Creating a new order", description = "In case the order is not created, the response will have a status of 404")
    @PostMapping
    public Integer createOrder(@RequestBody OrderDTO orderToCreate) {
        return orderService.createOrder(orderToCreate);
    }

    @Tag(name = "Delete an order by ID", description = "In case the order is not deleted by ID, the response will have a status of 404")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
    }

    @Tag(name = "Updating an order by ID", description = "In case the order is not updated correctly by ID, the response will have a status of 404")
    @PutMapping("/{id}")
    public OrderDTO update(@PathVariable Integer id, @RequestBody OrderDTO orderToUpdate) {
        return orderService.updateOrder(id, orderToUpdate);
    }
}
