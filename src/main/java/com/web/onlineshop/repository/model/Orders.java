package com.web.onlineshop.repository.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn (name = "client_id")
    private Client client;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusOrder status;
    @Column(name = "comment")
    private String comment;

    public Orders() {
    }

    public Orders(Integer id, Client client, Date orderDate, StatusOrder status, String comment) {
        this.id = id;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
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
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) && Objects.equals(client, orders.client) && Objects.equals(orderDate, orders.orderDate) && status == orders.status && Objects.equals(comment, orders.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, orderDate, status, comment);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", client=" + client +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                '}';
    }
}
