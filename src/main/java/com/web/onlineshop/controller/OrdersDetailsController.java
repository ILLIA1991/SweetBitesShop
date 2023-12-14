package com.web.onlineshop.controller;

import com.web.onlineshop.dto.OrderDetailsDTO;
import com.web.onlineshop.service.OrdersDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Order Details Management API", description = "API for retrieving order details")
@RestController
@RequestMapping("/details")
public class OrdersDetailsController {

    private final OrdersDetailsService ordersDetailsService;

    public OrdersDetailsController(OrdersDetailsService ordersDetailsService) {
        this.ordersDetailsService = ordersDetailsService;
    }

    @Tag(name = "Retrieving all order details", description = "Get details for all orders")
    @GetMapping
    public List<OrderDetailsDTO> getAllDetails() {
        return ordersDetailsService.getAll();
    }

    @Operation(summary = "Calculate total price",
            description = "Calculate the total price based on the provided product ID and quantity")
    @Parameters({
            @Parameter(name = "productId", description = "ID of the product", required = true),
            @Parameter(name = "quantity", description = "Quantity of the product", required = true)
    })
    @GetMapping("/price")
    public ResponseEntity<BigDecimal> getTotalPrice(@RequestParam Integer productId,
                                                    @RequestParam Integer quantity) {
        if (productId == null || quantity == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        BigDecimal totalPrice = ordersDetailsService.calculateTotalPrice(productId, quantity);

        if (totalPrice != null) {
            return new ResponseEntity<>(totalPrice, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
