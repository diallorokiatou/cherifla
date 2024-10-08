package com.poissonerie.cherifla.application.product;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.hamcrest.Matchers.hasItems;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private Integer port;

    static PostgreSQLContainer<?> postgreSQLContainer;

    static {
        postgreSQLContainer = new PostgreSQLContainer("postgres:13.3");
        postgreSQLContainer.withInitScript("scriptSQL/create_product_shema.sql");
    }

    @BeforeAll
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

    @Autowired
    private ProductRepositoryJpa repository;


    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        repository.deleteAll();
    }

    @Test
    void should_return_no_product() {
        // Given


        // When
        RestAssured.get("/products")
                .then()
                .statusCode(204);
    }

    @Test
    void should_return_all_products() {
        // Given

        repository.save(fishEntityBuilder());
        repository.save(fruitBuilder());

        // When
        RestAssured.get("/products")
                .then()
                .statusCode(200)
                .body("name", hasItems("Poisson", "Fruit"));

    }

    private ProductEntity fishEntityBuilder() {
        return ProductEntity.builder()
                .withName("Poisson")
                .withPricePerKg(10.0)
                .withAvailable(true)
                .build();
    }

    private ProductEntity fruitBuilder() {
        return ProductEntity.builder()
                .withName("Fruit")
                .withPricePerKg(5.0)
                .withAvailable(true)
                .build();
    }
}