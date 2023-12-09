package com.web.onlineshop.service;

import com.web.onlineshop.dto.OrderDetailsDTO;

import java.math.BigDecimal;
import java.util.List;

public interface OrdersDetailsService {

    List<OrderDetailsDTO> getAll();

    BigDecimal calculateTotalPrice(Integer productId, Integer quantity);
}
