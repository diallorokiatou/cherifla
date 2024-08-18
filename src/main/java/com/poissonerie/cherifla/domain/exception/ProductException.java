package com.poissonerie.cherifla.domain.exception;

import static com.poissonerie.cherifla.domain.exception.ExceptionMessage.PRODUCT_INFORMATION_INCOMPLETE;
import static com.poissonerie.cherifla.domain.exception.ExceptionMessage.PRODUCT_NOT_FOUND;

public class ProductException extends RuntimeException {

    public static ProductException productNotFoundException() {
        return builder()
                .withMessage(PRODUCT_NOT_FOUND.message())
                .build();
    }

    public static ProductException productIncompleteInformations(){
        return builder()
                .withMessage(PRODUCT_INFORMATION_INCOMPLETE.message())
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String message;

        private Builder() {
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ProductException build() {
            return new ProductException();
        }
    }



}
