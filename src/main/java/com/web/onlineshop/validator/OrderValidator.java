package com.web.onlineshop.validator;

import com.web.onlineshop.dto.ClientDTO;
import com.web.onlineshop.dto.OrderDTO;
import com.web.onlineshop.exception.ValidationException;
import com.web.onlineshop.repository.model.StatusOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class OrderValidator {

    private static final Pattern ONLY_LETTERS_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");

    public void validateOrder(OrderDTO orderDTO) {
        List<String> violations = new ArrayList<>();

        validateClient(orderDTO.getClientDTO(), violations);
        validateOrderDate(orderDTO.getOrderDate(), violations);
        validateStatus(orderDTO.getStatus(), violations);
        validateComment(orderDTO.getComment(), violations);

        if (!violations.isEmpty()) {
            throw new ValidationException("Provided order is invalid!", violations);
        }
    }

    private void validateClient(ClientDTO clientDTO, List<String> violations) {
        if (clientDTO == null) {
            violations.add("Client must not be null");
        } else {
            validateString(clientDTO.getName(), "Name", violations);
            validateString(clientDTO.getSurname(), "Surname", violations);
            validatePattern(clientDTO.getEmail(), "Email", EMAIL_PATTERN, violations);
            validatePattern(clientDTO.getPhoneNumber(), "Phone number", PHONE_NUMBER_PATTERN, violations);
        }
    }

    private void validateOrderDate(Date orderDate, List<String> violations) {
        if (orderDate == null) {
            violations.add("Order date must not be null");
        }
    }

    private void validateStatus(String status, List<String> violations) {
        if (status == null || StatusOrder.getByDisplayName(status.toUpperCase()).isEmpty()) {
            violations.add("Invalid order status");
        }
    }

    private void validateComment(String comment, List<String> violations) {
        if (comment == null || comment.trim().isEmpty()) {
            violations.add("Comment must not be empty");
        }
    }

    private void validateString(String value, String fieldName, List<String> violations) {
        if (value == null || value.trim().isEmpty()) {
            violations.add(fieldName + " must not be null or empty");
        } else if (!OrderValidator.ONLY_LETTERS_PATTERN.matcher(value).matches()) {
            violations.add(fieldName + " must match the pattern: " + OrderValidator.ONLY_LETTERS_PATTERN.pattern());
        }
    }

    private void validatePattern(String value, String fieldName, Pattern pattern, List<String> violations) {
        if (value != null && !pattern.matcher(value).matches()) {
            violations.add(fieldName + " must match the pattern: " + pattern.pattern());
        }
    }
}
