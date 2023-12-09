package com.web.onlineshop.controller;

import com.web.onlineshop.dto.OrderDetailsDTO;
import com.web.onlineshop.service.OrdersDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/details")
public class OrdersDetailsController {

    private final OrdersDetailsService ordersDetailsService;

    public OrdersDetailsController(OrdersDetailsService ordersDetailsService) {
        this.ordersDetailsService = ordersDetailsService;
    }

    @GetMapping
    public List<OrderDetailsDTO> getAllDetails() {
        return ordersDetailsService.getAll();
    }

    @GetMapping("/price")
    public ResponseEntity<BigDecimal> getTotalPrice(@RequestParam Integer productId,
                                                    @RequestParam Integer quantity) {
        if(productId == null || quantity == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BigDecimal totalPrice = ordersDetailsService.calculateTotalPrice(productId, quantity);

        if(totalPrice != null) {
            return new ResponseEntity<>(totalPrice, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
