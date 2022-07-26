package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.JdbcDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


public class Program {
    private static final String EXIT = "exit";

    private static long id;

    public static void main(String[] args) {
        JdbcDataSource dataSource = new JdbcDataSource();

        updateData("src/main/resources/data.sql", dataSource);
        updateData("src/main/resources/schema.sql", dataSource);

        User creator = new User(6L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(6L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource.getDataSource());
        messagesRepository.save(message);
        System.out.println(message.getMessageId());
    }

    public static void updateData(String file, JdbcDataSource dataSource) {
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            Scanner scanner = new Scanner(file).useDelimiter(";");

            scanner.next();
            while (scanner.hasNext()) {
                st.executeUpdate(scanner.next().trim());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
