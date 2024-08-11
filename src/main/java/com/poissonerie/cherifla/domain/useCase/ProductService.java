package com.poissonerie.cherifla.domain.useCase;

import com.poissonerie.cherifla.domain.model.Product;
import com.poissonerie.cherifla.domain.port.ProductRepository;

import java.util.HashSet;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public HashSet<Product> getAllProducts() {
        return Optional.ofNullable(productRepository.getAllProducts())
                .orElse(new HashSet<>());
    }

    public void addProduct(Product product) {
        if(!product.hasCompleteInformation()) {
            throw new IllegalArgumentException("Product information is incomplete");
        }
        productRepository.addProduct(product);
    }

    public Optional<Product> updateProduct(Product product) {
        if(productRepository.getProductByName(product.name()).isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }
        return productRepository.updateProduct(product);
    }

    public void deleteProduct(String name) {
        if(productRepository.getProductByName(name).isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }
        productRepository.deleteProductByName(name);
    }
}
