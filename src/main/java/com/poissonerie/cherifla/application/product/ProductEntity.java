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
    private final Long id;

    @Column(nullable = false)
    private final String name;

    @Column
    private final String description;

    @Column(nullable = false)
    private final double pricePerKg;

    @Column(nullable = false)
    private final Boolean available;

    public ProductEntity from(Product product) {
        return new ProductEntity(product.id(), product.name(), product.description(), product.pricePerKg(), product.available());
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


}
