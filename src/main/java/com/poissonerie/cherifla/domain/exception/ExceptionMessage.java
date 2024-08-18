package com.poissonerie.cherifla.domain.exception;

public enum ExceptionMessage {
    PRODUCT_NOT_FOUND("Product not found"),
    PRODUCT_ALREADY_EXISTS("Product already exists"),
    PRODUCT_INFORMATION_INCOMPLETE("Product informationS ARE incomplete");

    private final String message;
    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
