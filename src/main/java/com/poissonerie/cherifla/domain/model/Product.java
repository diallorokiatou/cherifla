package com.poissonerie.cherifla.domain.model;

public record Product(Long id, String name, String description, double pricePerKg, boolean available) {
    public static Builder builder() {
        return new Builder();
    }
    public boolean hasCompleteInformation() {
        return name != null && description != null && pricePerKg > 0;
    }

    public static Product from(Product product) {
        return new Builder()
                .withId(product.id())
                .withName(product.name())
                .withDescription(product.description())
                .withPricePerKg(product.pricePerKg())
                .withAvailable(product.available())
                .build();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private double pricePerKg;
        private boolean available;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPricePerKg(double pricePerKg) {
            this.pricePerKg = pricePerKg;
            return this;
        }

        public Builder withAvailable(boolean available) {
            this.available = available;
            return this;
        }

        public Product build() {
            return new Product(id, name, description, pricePerKg, available);
        }
    }

}
