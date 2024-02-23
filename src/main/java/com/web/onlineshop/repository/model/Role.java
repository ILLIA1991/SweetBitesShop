package com.web.onlineshop.repository.model;

public enum Role {

    ADMIN("Admin"),
    CLIENT("Client");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Role findByValue(String value) {
        for (Role role : values()) {
            if (role.getValue().equalsIgnoreCase(value)) {
                return role;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String roleValue = "Client";
        Role role = Role.findByValue(roleValue);
        if (role != null) {
            System.out.println("Role found: " + role.getValue());
        } else {
            System.out.println("Role not found for value: " + roleValue);
        }
    }
}
