package com.web.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
public class OrdersDetailsDTO {

    private Integer id;
    private OrdersDTO orders;
    private ProductDTO product;
    private Integer quantity;
    private BigDecimal totalPrice;

}
