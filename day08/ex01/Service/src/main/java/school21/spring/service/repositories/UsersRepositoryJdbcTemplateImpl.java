package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl extends JdbcTemplate implements UsersRepository {
    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        super(dataSource);
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();

            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM models.user WHERE id =" + id;
        User user = query(sql,
                (PreparedStatementSetter) new MapSqlParameterSource().addValue("id", id),
                new UserRowMapper()).stream().findAny().orElse(null);
        return user;
    }

    private static final class UserMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }
    @Override
    public List<User> findAll() {
        List<User> users = query( "select id, email from models.user", new UserMapper());
        return users;
    }

    @Override
    public void save(User entity) {
        update("insert into models.user (id, email) values (?, ?)", entity.getId(), entity.getEmail());
    }

    @Override
    public void update(User entity) {
        update("update models.user set email = ? where id = ?", entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        update("delete from models.user where id = ?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM models.user WHERE email = " + email;
        User user = query(sql,
                (PreparedStatementSetter) new MapSqlParameterSource().addValue("email", email),
                new UserRowMapper()).stream().findAny().orElse(null);
        return Optional.ofNullable(user);
    }
}
