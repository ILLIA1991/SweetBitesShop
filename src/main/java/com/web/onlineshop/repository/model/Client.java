package com.web.onlineshop.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "country")
    private String country;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "blocked")
    private boolean blocked;

    public Client() {
    }

    public Client(Integer id, String name, String surname, String username, String password, String email, String address, String country, String phoneNumber, Role role, boolean blocked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username" + username + '\'' +
                ", password" + password + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                ", blocked=" + blocked +
                '}';
    }
}
