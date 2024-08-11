package com.poissonerie.cherifla.domain.port;

import com.poissonerie.cherifla.domain.model.Product;

import java.util.HashSet;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> getProductById(int id);
    Optional<Product> getProductByName(String name);
    HashSet<Product> getAllProducts();
    void addProduct(Product product);
    Optional<Product> updateProduct(Product product);
    void deleteProduct(int id);

    void deleteProductByName(String name);

    void deleteAll();
}
