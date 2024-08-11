package com.poissonerie.cherifla.domain.model;

public record Product(String name, String description, double pricePerKg, Boolean available) {
    public Product(ProductBuilder builder) {
        this(builder.name, builder.description, builder.pricePerKg, builder.available);
    }

    public static final class ProductBuilder {
        private String name;
        private String description;
        private double pricePerKg;
        private Boolean available;

        private ProductBuilder() {
        }

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder withPricePerKg(double pricePerKg) {
            this.pricePerKg = pricePerKg;
            return this;
        }

        public ProductBuilder withAvailable(Boolean available) {
            this.available = available;
            return this;
        }

        public Product build() {
            return new Product(name, description, pricePerKg, available);
        }
    }
}
