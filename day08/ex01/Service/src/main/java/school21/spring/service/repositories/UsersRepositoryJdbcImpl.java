package school21.spring.service.repositories;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private final String Id = "SELECT * FROM models.user WHERE id = ";
    private final String Delete = "SELECT * FROM models.user WHERE id = ";
    private final String Email = "SELECT * FROM models.user WHERE email = ";
    private final String All = "SELECT * FROM models.user";
    private final String Update = "UPDATE models.user SET email = ";
    private final String Save = "INSERT INTO models.user (id, email) VALUES (";
    private final DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public User findById(Long id) {
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(Id + id);

            if (!rs.next()) {
                return null;
            }
            return new User(rs.getLong(1), rs.getString(2));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(All);

            while (rs.next()) {
                users.add(new User(rs.getLong(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users.isEmpty() ? null : users;
    }

    @Override
    public void save(User entity) {
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            int result = st.executeUpdate(Save
                    + entity.getId() + ", '"
                    + entity.getEmail() + "');");

            if (result == 0) {
                System.err.println("User wasn't saved with id: " + entity.getId());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void update(User entity) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement(Update
             + entity.getEmail() + " WHERE id = " + entity.getId())) {
            int result = st.executeUpdate();

            if (result == 0) {
                System.err.println("User wasn't updated with id: " + entity.getId());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement(Delete + id)) {
            int result = st.executeUpdate();

            if (result == 0) {
                System.err.println("User not found with id: " + id);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement(Email + email)) {
            ResultSet rs = st.executeQuery();

            if (!rs.next()) {
                return Optional.empty();
            }
            return Optional.of(new User(rs.getLong(1), rs.getString(2)));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }
}
