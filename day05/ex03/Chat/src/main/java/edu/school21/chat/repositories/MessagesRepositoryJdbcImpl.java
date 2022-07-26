package edu.school21.chat.repositories;

import edu.school21.chat.exception.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private User findUser(Long id) throws SQLException {
        String uQuery = "SELECT * FROM chat.user WHERE id = " + id;

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(uQuery);

            if (!rs.next()) {
                return null;
            }
            return new User(id, rs.getString(2), rs.getString(3));
        }
    }

    private Chatroom findChat(Long id) throws SQLException {
        String cQuery = "SELECT * FROM chat.chatroom WHERE id = " + id;

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(cQuery);

            if (!rs.next()) {
                return null;
            }
            return new Chatroom(id, rs.getString(2));
        }
    }

    @Override
    public Optional<Message> findById(long id) {
        String mQuery = "SELECT * FROM chat.message WHERE id = " + id;

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(mQuery);

            if (!rs.next()) {
                return null;
            }
            Long userId = rs.getLong(2);
            Long roomId = rs.getLong(3);
            User user = findUser(userId);
            Chatroom room = findChat(roomId);
            return Optional.of(new Message(userId, user, room, rs.getString(4), rs.getTimestamp(5).toLocalDateTime()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void save(Message message) {
        String sql = "INSERT INTO chat.message (author_id, room_id, text, date_time) VALUES ("
                + message.getMessageAuthor().getUserId()
                + ", '" + message.getMessageRoom().getChatRoomId()
                + "', '" + message.getMessageText()
                + "', '" + message.getMessageDateTime()
                + "');";

        try (Connection con = dataSource.getConnection();
             PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            statement.execute();
            ResultSet set = statement.getGeneratedKeys();
            set.next();
            message.setMessageId(set.getInt(1));

        } catch (NotSavedSubEntityException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Message message) {
        String sql = "UPDATE chat.message SET "
                + "author_id = '" + message.getMessageAuthor().getUserId()
                + "', room_id = '" + message.getMessageRoom().getChatRoomId()
                + "', text = '" + message.getMessageText()
                + "', date_time = '" + message.getMessageDateTime()
                + "' WHERE id = " + message.getMessageId() + ";";

        try (Connection con = dataSource.getConnection();
             PreparedStatement statement = con.prepareStatement(sql))
        {
            statement.executeUpdate();
        } catch (NotSavedSubEntityException | SQLException e) {
            e.printStackTrace();
        }
    }
}
