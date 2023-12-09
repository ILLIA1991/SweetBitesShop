package com.web.onlineshop.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderDetailsDTO {

    private Integer id;
    private OrderDTO ordersId;
    private ProductDTO productId;
    private Integer quantity;
    private BigDecimal totalPrice;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(Integer id, OrderDTO ordersId, ProductDTO productId, Integer quantity, BigDecimal totalPrice) {
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

    public OrderDTO getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(OrderDTO ordersId) {
        this.ordersId = ordersId;
    }

    public ProductDTO getProductId() {
        return productId;
    }

    public void setProductId(ProductDTO productId) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsDTO that = (OrderDetailsDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(ordersId, that.ordersId) && Objects.equals(productId, that.productId) && Objects.equals(quantity, that.quantity) && Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordersId, productId, quantity, totalPrice);
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
