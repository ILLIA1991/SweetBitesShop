package com.web.onlineshop.dto;

import com.web.onlineshop.repository.model.Role;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

public class AdminDTO {

    private Long id;

    private String username;
    private String password;

    private RoleDTO roleDTO;

    public AdminDTO() {
    }

    public AdminDTO(Long id, String username, String password, RoleDTO roleDTO) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleDTO = roleDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO adminDTO = (AdminDTO) o;
        return Objects.equals(id, adminDTO.id) && Objects.equals(username, adminDTO.username) && Objects.equals(password, adminDTO.password) && Objects.equals(roleDTO, adminDTO.roleDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, roleDTO);
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleDTO=" + roleDTO +
                '}';
    }
}
