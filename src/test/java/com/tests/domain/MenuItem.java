package com.tests.domain;

public enum MenuItem {
    BUSINESS("Бизнес"),
    CASHBOX("Касса"),
    INVESTMENTS("Инвестиции");

    private String description;

    MenuItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
