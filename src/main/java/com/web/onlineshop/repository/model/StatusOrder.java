package com.web.onlineshop.repository.model;

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

    public String getDisplayName() {
        return displayName;
    }
}