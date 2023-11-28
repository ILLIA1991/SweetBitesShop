package com.web.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
@Data
public class OrdersDTO {
    private Integer id;
    private ClientDTO clientDTO;
    private Date orderDate;
    private StatusOrder statusOrder;
    private String comment;
}
