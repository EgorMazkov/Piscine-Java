package school21.spring.service.repositories;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private final String idQuery = "SELECT * FROM models.user WHERE id = :id";
    private final String emQuery = "SELECT * FROM models.user WHERE email = :email";
    private final String alQuery = "SELECT * FROM models.user";
    private final String upQuery = "UPDATE models.user SET email = :email WHERE id = :id";
    private final String dlQuery = "DELETE FROM models.user WHERE id = :id";
    private final String inQuery = "INSERT INTO models.user (id, email) VALUES (:id, :email)";
    private final DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
