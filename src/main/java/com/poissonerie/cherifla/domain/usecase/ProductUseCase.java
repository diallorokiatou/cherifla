package com.poissonerie.cherifla.domain.usecase;

import com.poissonerie.cherifla.domain.model.Product;
import com.poissonerie.cherifla.domain.port.ProductRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.poissonerie.cherifla.domain.exception.ProductException.productIncompleteInformations;
import static com.poissonerie.cherifla.domain.exception.ProductException.productNotFoundException;

public class ProductUseCase {
    private final ProductRepository productRepository;

    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id)
                .orElseThrow(() -> productNotFoundException());
    }

    public Set<Product> getAllProducts() {
        return Optional.ofNullable(productRepository.getAllProducts())
                .orElse(new HashSet<>());
    }



    public void addProduct(Product product) {
        if(!product.hasCompleteInformation()) {
            throw productIncompleteInformations();
        }
        productRepository.addProduct(product);
    }

    public Optional<Product> updateProduct(Product product) {
        if(productRepository.getProductByName(product.name()).isEmpty()) {
            throw productNotFoundException();
        }
        return productRepository.updateProduct(product);
    }

    public void deleteProduct(String name) {
        if(productRepository.getProductByName(name).isEmpty()) {
            throw productNotFoundException();
        }
        productRepository.deleteProductByName(name);
    }
}
