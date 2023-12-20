package com.web.onlineshop.repository.model;

import java.util.Arrays;
import java.util.Optional;

public enum StatusOrder {

    CREATED("Created"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String displayName;

    StatusOrder(String displayName) {
        this.displayName = displayName;
    }

    public static Optional<StatusOrder> getByDisplayName(String displayName) {
        return Arrays.stream(values())
                .filter(status -> status.getDisplayName().equalsIgnoreCase(displayName))
                .findFirst();
    }

    public String getDisplayName() {
        return displayName;
    }
}
