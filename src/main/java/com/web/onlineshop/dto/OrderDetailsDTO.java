package com.web.onlineshop.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderDetailsDTO {

    private Integer id;
    private OrderDTO ordersDTO;
    private ProductDTO productDTO;
    private Integer quantity;
    private BigDecimal totalPrice;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(Integer id, OrderDTO ordersDTO, ProductDTO productDTO, Integer quantity, BigDecimal totalPrice) {
        this.id = id;
        this.ordersDTO = ordersDTO;
        this.productDTO = productDTO;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderDTO getOrdersDTO() {
        return ordersDTO;
    }

    public void setOrdersDTO(OrderDTO ordersDTO) {
        this.ordersDTO = ordersDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
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
        return Objects.equals(id, that.id) && Objects.equals(ordersDTO, that.ordersDTO) && Objects.equals(productDTO, that.productDTO) && Objects.equals(quantity, that.quantity) && Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordersDTO, productDTO, quantity, totalPrice);
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "id=" + id +
                ", ordersId=" + ordersDTO +
                ", productId=" + productDTO +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
