package com.poissonerie.cherifla.application.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poissonerie.cherifla.domain.model.Product;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private double pricePerKg;

    @Column(nullable = false)
    private Boolean available;

    public ProductEntity from(Product product) {
        return ProductEntity
                .builder()
                .withId(product.id())
                .withName(product.name())
                .withDescription(product.description())
                .withPricePerKg(product.pricePerKg())
                .withAvailable(product.available())
                .build();
    }

    public Product to() {
        return Product
                .builder()
                .withId(id)
                .withName(name)
                .withDescription(description)
                .withPricePerKg(pricePerKg)
                .withAvailable(available)
                .build();
    }

    public ProductEntity() {
    }

    public ProductEntity(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("pricePerKg") double pricePerKg, @JsonProperty("available") Boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerKg = pricePerKg;
        this.available = available;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public double pricePerKg() {
        return pricePerKg;
    }

    public Boolean available() {
        return available;
    }



    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pricePerKg=" + pricePerKg +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, pricePerKg, available);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private double pricePerKg;
        private Boolean available;

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

        public Builder withAvailable(Boolean available) {
            this.available = available;
            return this;
        }

        public ProductEntity build() {
            return new ProductEntity(id, name, description, pricePerKg, available);
        }
    }

}
