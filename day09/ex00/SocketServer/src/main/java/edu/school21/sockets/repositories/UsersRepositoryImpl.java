package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryImpl implements UsersRepository {
    private final JdbcTemplate template;

    public UsersRepositoryImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    private static class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();

            user.setId(rs.getLong("user_id"));
            user.setClientName(rs.getString("user_name"));
            user.setClientPassword(rs.getString("user_password"));
            return user;
        }
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM server.user WHERE id = ?";
        return template.queryForObject(sql, new UserRowMapper(), id);
    }

    private static final class UserMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("user_id"));
            user.setClientName(rs.getString("user_name"));
            user.setClientPassword(rs.getString("user_password"));
            return user;
        }
    }
    @Override
    public List<User> findAll() {
        List<User> users = template.query( "select id, email from server.user", new UserMapper());
        return users;
    }

    @Override
    public void save(User entity) {
        template.update("insert into server.user (user_name, user_password) values (?, ?)", entity.getClientName(), entity.getClientPassword());
    }

    @Override
    public void update(User entity) {
        template.update("update server.user set user_name = ?, user_password = ? where user_id = ?",entity.getClientName(), entity.getClientPassword(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        template.update("delete from server.user where id = ?", id);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        String sql = "SELECT * FROM server.user WHERE user_name = ?";
        try {
            return Optional.ofNullable(template.query(sql, new UserRowMapper(), userName).get(0));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
