package com.poissonerie.cherifla.application.product;

import com.poissonerie.cherifla.domain.model.Product;

public record ProductResponse(Long id, String name, String description, double pricePerKg, Boolean available) {
    public ProductResponse(ProductResponseBuilder builder) {
        this(builder.id, builder.name, builder.description, builder.pricePerKg, builder.available);
    }

    public static ProductResponse from(Product product) {
        return new ProductResponseBuilder()
                .withId(product.id())
                .withName(product.name())
                .withDescription(product.description())
                .withPricePerKg(product.pricePerKg())
                .withAvailable(product.available())
                .build();
    }

    public static final class ProductResponseBuilder {
        private Long id;
        private String name;
        private String description;
        private double pricePerKg;
        private Boolean available;

        private ProductResponseBuilder() {
        }

        public ProductResponseBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ProductResponseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductResponseBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductResponseBuilder withPricePerKg(double pricePerKg) {
            this.pricePerKg = pricePerKg;
            return this;
        }

        public ProductResponseBuilder withAvailable(Boolean available) {
            this.available = available;
            return this;
        }

        public ProductResponse build() {
            return new ProductResponse(id, name, description, pricePerKg, available);
        }
    }
}
