package com.web.onlineshop.dto;

import com.web.onlineshop.repository.model.Role;

import java.util.Objects;

public class ClientDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String country;
    private String phoneNumber;

    private Role role;

    private boolean blocked;

    public ClientDTO() {
    }

    public ClientDTO(Integer id, String name, String surname, String email, String address, String country, String phoneNumber, Role role, boolean blocked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.blocked = blocked;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return blocked == clientDTO.blocked && Objects.equals(id, clientDTO.id) && Objects.equals(name, clientDTO.name) && Objects.equals(surname, clientDTO.surname) && Objects.equals(email, clientDTO.email) && Objects.equals(address, clientDTO.address) && Objects.equals(country, clientDTO.country) && Objects.equals(phoneNumber, clientDTO.phoneNumber) && Objects.equals(role, clientDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, address, country, phoneNumber, role, blocked);
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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                ", blocked=" + blocked +
                '}';
    }
}
