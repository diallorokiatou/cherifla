package com.poissonerie.cherifla.application.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, Long> {

}
