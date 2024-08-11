package com.poissonerie.cherifla.domain.model;

public record Product(Long id, String name, String description, double pricePerKg, Boolean available) {
    public Product(ProductBuilder builder) {
        this(builder.id, builder.name, builder.description, builder.pricePerKg, builder.available);
    }

    public Boolean hasCompleteInformation() {
        return name != null && description != null && pricePerKg > 0 && available != null;
    }

    public static final class ProductBuilder {
        private Long id;
        private String name;
        private String description;
        private double pricePerKg;
        private Boolean available;

        public ProductBuilder() {
        }

        public ProductBuilder withId(Long id) {
            this.id = id;
            return this;
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
            return new Product(id, name, description, pricePerKg, available);
        }
    }
}
