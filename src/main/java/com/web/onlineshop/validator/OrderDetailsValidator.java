package com.web.onlineshop.validator;

import com.web.onlineshop.dto.OrderDTO;
import com.web.onlineshop.dto.OrderDetailsDTO;
import com.web.onlineshop.dto.ProductDTO;
import com.web.onlineshop.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetailsValidator {

    public void validateOrderDetails(OrderDetailsDTO orderDetailsDTO) throws ValidationException {
        List<String> violations = new ArrayList<>();
        validateOrderId(OrderDetailsDTO.getOrdersDTO(), violations);
        validateProductId(orderDetailsDTO.getProductDTO(), violations);
        validateQuantity(orderDetailsDTO.getQuantity(), violations);
        validatePrice(orderDetailsDTO.getTotalPrice(), violations);

        if (!violations.isEmpty()) {
            throw new ValidationException("Provided order details are invalid!", violations);
        }
    }

    private void validateOrderId(OrderDTO orderDTO, List<String> violations) {
        if (orderDTO == null || orderDTO.getId() == null) {
            violations.add("Order ID must not be null");
        }
    }

    private void validateProductId(ProductDTO productDTO, List<String> violations) {
        if (productDTO == null || productDTO.getId() == null) {
            violations.add("Product ID must not be null");
        }
    }

    private void validateQuantity(Integer quantity, List<String> violations) {
        if (quantity == null || quantity <= 0) {
            violations.add("Quantity must be greater than zero");
        }
    }

    private void validatePrice(BigDecimal price, List<String> violations) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            violations.add("Price must be greater than zero");
        }
    }
}
