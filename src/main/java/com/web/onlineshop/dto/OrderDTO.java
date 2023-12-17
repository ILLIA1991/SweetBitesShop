package com.web.onlineshop.dto;

import java.util.Date;
import java.util.Objects;

public class OrderDTO {
    private Integer id;
    private ClientDTO clientDTO;
    private Date orderDate;
    private String status;
    private String comment;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, ClientDTO clientDTO, Date orderDate, String status, String comment) {
        this.id = id;
        this.clientDTO = clientDTO;
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

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
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
        return Objects.equals(id, orderDTO.id) && Objects.equals(clientDTO, orderDTO.clientDTO) && Objects.equals(orderDate, orderDTO.orderDate) && Objects.equals(status, orderDTO.status) && Objects.equals(comment, orderDTO.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientDTO, orderDate, status, comment);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", clientDTO=" + clientDTO +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
