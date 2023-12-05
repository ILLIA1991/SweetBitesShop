package com.web.onlineshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String country;
    private String phone_number;

    public ClientDTO() {
    }

    public ClientDTO(Integer id, String name, String surname, String email, String address, String country, String phone_number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.country = country;
        this.phone_number = phone_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id) && Objects.equals(name, clientDTO.name) && Objects.equals(surname, clientDTO.surname) && Objects.equals(email, clientDTO.email) && Objects.equals(address, clientDTO.address) && Objects.equals(country, clientDTO.country) && Objects.equals(phone_number, clientDTO.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, address, country, phone_number);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
