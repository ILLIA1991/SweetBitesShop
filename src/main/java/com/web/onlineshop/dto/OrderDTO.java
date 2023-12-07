package com.web.onlineshop.dto;

import com.web.onlineshop.repository.model.Client;

import java.util.Date;
import java.util.Objects;

public class OrderDTO {
    private Integer id;
    private Client clientId;
    private Date orderDate;
    private String status;
    private String comment;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, Client clientId, Date orderDate, String status, String comment) {
        this.id = id;
        this.clientId = clientId;
        this.orderDate = orderDate;
        this.status = status;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(clientId, orderDTO.clientId) && Objects.equals(orderDate, orderDTO.orderDate) && Objects.equals(status, orderDTO.status) && Objects.equals(comment, orderDTO.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, orderDate, status, comment);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", order_date=" + orderDate +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
