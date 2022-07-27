package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ProductsRepositoryJdbcImplTest {
    final List<Product> FIND_ALL = Arrays.asList(
            new Product(1L, "dota", 1000L),
            new Product(2L, "csgo", 150L),
            new Product(3L, "honor 8x", 15499L),
            new Product(4L, "honor 9x lite", 22999L),
            new Product(5L, "amazfit", 5499L),
            new Product(6L, "milk", 89L),
            new Product(7L, "slack", 1541L),
            new Product(8L, "tiktok", 1542L));
    final Product EXPECTED_SAVE_PRODUCT = new Product(9L, "tititoki", 87235L);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(6L, "milk", 157L);
    final Product EXPECTED_DELETE_PRODUCT = new Product(1L, "dota", 1000L);
    final Product FIND_BY_ID = new Product(3L, "honor 8x", 15499L);
    final List<Product> PRODUCTS_AFTER_DELETE = Arrays.asList(
            new Product(2L, "csgo", 150L),
            new Product(3L, "honor 8x", 15499L),
            new Product(4L, "honor 9x lite", 22999L),
            new Product(5L, "amazfit", 5499L),
            new Product(6L, "milk", 89L),
            new Product(7L, "slack", 1541L),
            new Product(8L, "tiktok", 1542L));

    private ProductsRepository repository;
    private DataSource dataSource;

    @BeforeEach
    public void init() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("/schema.sql")
                .addScript("/data.sql")
                .build();
        repository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    public void all() {
        List<Product> actual = repository.findAll();
        assertEquals(FIND_ALL, actual);
    }

    @Test
    public void save() {
        repository.save(EXPECTED_SAVE_PRODUCT);
        assertEquals(EXPECTED_SAVE_PRODUCT, repository.findById(EXPECTED_SAVE_PRODUCT.getIdentifier()).get());
    }

    @Test
    public void update() {
        repository.update(EXPECTED_UPDATED_PRODUCT);
        assertEquals(EXPECTED_UPDATED_PRODUCT, repository.findById(EXPECTED_UPDATED_PRODUCT.getIdentifier()).get());
    }

    @Test
    public void delete() {
        repository.delete(EXPECTED_DELETE_PRODUCT.getIdentifier());
        assertFalse(repository.findById(EXPECTED_DELETE_PRODUCT.getIdentifier()).isPresent());
    }

    @Test
    public void findByIdTest() {
        assertEquals(FIND_BY_ID, repository.findById(3L).get());
    }

    @Test
    public void shouldEmptyWhenIdNotExist() {
        assertEquals(Optional.empty(), repository.findById(10l));
    }

    @Test
    public void shouldEmptyWhenIdNull() {
        assertEquals(Optional.empty(), repository.findById(null));
    }
}
