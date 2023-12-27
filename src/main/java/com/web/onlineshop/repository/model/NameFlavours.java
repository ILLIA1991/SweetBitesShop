package com.web.onlineshop.repository.model;

public enum NameFlavours {

    BANANA("Banana"),
    STRAWBERRY("Strawberry"),
    CHERRY("Cherry"),
    CHOCOLATE("Chocolate");

    final String value;

    public String getValue() {
        return value;
    }

    NameFlavours(String value) {
        this.value = value;
    }

    public static NameFlavours findByValue(String value) {
        NameFlavours result = null;
        for (NameFlavours flavours : values()) {
            if (flavours.getValue().equalsIgnoreCase(value)) {
                result = flavours;
                break;
            }
        }
        return result;
    }
}
