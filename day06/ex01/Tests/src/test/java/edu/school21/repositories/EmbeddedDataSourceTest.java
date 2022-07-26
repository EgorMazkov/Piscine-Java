package edu.school21.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
public class EmbeddedDataSourceTest {
    public DataSource dataSource;

    @BeforeEach
    public void init() {
        dataSource = new EmbeddedDatabaseBuilder()
                .addScript("/schema.sql")
                .addScript("/data.sql")
                .build();
    }

    @Test
    public void getConnection() {
        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            fail();
        }
    }

}
