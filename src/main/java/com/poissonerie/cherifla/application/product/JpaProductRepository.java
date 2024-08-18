package com.poissonerie.cherifla.application.product;

import com.poissonerie.cherifla.domain.model.Product;
import com.poissonerie.cherifla.domain.port.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaProductRepository implements ProductRepository {

    private final ProductRepositoryJpa productRepositoryJpa;

    public JpaProductRepository(ProductRepositoryJpa productRepositoryJpa) {
        this.productRepositoryJpa = productRepositoryJpa;
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return Optional.empty();
    }

    @Override
    public HashSet<Product> getAllProducts() {
        return productRepositoryJpa.findAll().stream()
                .map(ProductEntity::to)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        return Optional.empty();
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public void deleteProductByName(String name) {

    }

    @Override
    public void deleteAll() {

    }
}
