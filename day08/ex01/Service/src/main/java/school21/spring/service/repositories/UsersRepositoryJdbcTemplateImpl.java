package school21.spring.service.repositories;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private DriverManagerDataSource dataSource;

    public UsersRepositoryJdbcTemplateImpl(DriverManagerDataSource driverManagerDataSource) {
        this.dataSource = driverManagerDataSource;
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
