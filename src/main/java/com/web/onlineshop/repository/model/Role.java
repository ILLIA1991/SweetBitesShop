package com.web.onlineshop.repository.model;


public enum Role {

    ADMIN("Admin"),
    CLIENT("Client");

    final String value;

    public String getValue() {
        return value;
    }

    Role(String value) {
        this.value = value;
    }

//    public static Role findByValue(String value) {
//        Role result = null;
//        for (Role role : values()) {
//            if (role.getValue().equalsIgnoreCase(value)) {
//                result = role;
//                break;
//            }
//        }
//        return result;
//    }
}
