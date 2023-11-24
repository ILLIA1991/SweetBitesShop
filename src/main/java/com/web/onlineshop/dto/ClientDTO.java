package com.web.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String country;
    private String phone_number;
}
