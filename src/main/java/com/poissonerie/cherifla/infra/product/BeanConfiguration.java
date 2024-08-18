package com.poissonerie.cherifla.infra.product;

import com.poissonerie.cherifla.application.product.JpaProductRepository;
import com.poissonerie.cherifla.application.product.ProductRepositoryJpa;
import com.poissonerie.cherifla.domain.usecase.ProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {
    @Autowired
    private ProductRepositoryJpa productRepositoryJpa;

    @Bean
    public ProductUseCase productUseCase() {
        return new ProductUseCase(productRepository());
    }

    public JpaProductRepository productRepository() {
        return new JpaProductRepository(productRepositoryJpa);
    }


}
