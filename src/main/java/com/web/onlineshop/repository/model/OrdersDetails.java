package com.web.onlineshop.repository.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "orders_details")
public class OrdersDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders ordersId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public OrdersDetails() {
    }

    public OrdersDetails(Integer id, Orders ordersId, Product productId, Integer quantity, BigDecimal totalPrice) {
        this.id = id;
        this.ordersId = ordersId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Orders getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Orders ordersId) {
        this.ordersId = ordersId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString() {
        return "OrdersDetails{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
