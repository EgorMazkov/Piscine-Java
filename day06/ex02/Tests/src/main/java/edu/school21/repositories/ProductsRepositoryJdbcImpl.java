package edu.school21.repositories;

import edu.school21.models.Product;
import org.w3c.dom.ls.LSOutput;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {


    static final String DELETE = "DELETE FROM shop.products WHERE identifier = ";
    static final String ALL = "SELECT * FROM shop.products";
    static final String INSERT = "INSERT INTO shop.products (IDENTIFIER, NAMES, PRIME) VALUES (";
    static final String UPDATE = "UPDATE shop.products SET ";

    private final DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() {
        List<Product> lists = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(ALL);

            while (rs.next()) {
                Product product = new Product(rs.getLong(1),
                        rs.getString(2), rs.getLong(3));
                lists.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lists;
    }

    @Override
    public Optional<Product> findById(Long id) {
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM shop.products WHERE identifier = " + id + ";");

            if (!rs.next()) {
                return Optional.empty();
            }
            Product product = new Product(rs.getLong(1),
                    rs.getString(2), rs.getLong(3));
            return Optional.of(product);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void update(Product product) {
        String sql = UPDATE + "names = '" + product.getNames() + "', " + "prime = " + product.getPrice() + " WHERE identifier = " + product.getIdentifier() +";";
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement())
        {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Product product) {
        String sql = INSERT
                + product.getIdentifier() + ", '"
                + product.getNames() + "', "
                + product.getPrice() + ");";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            st.execute(DELETE + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
