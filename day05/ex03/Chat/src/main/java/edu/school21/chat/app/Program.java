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

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource.getDataSource());
        Optional<Message> messageOptional = messagesRepository.findById(3);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setMessageText("Bye");
            message.setMessageDateTime(null);
            messagesRepository.update(message);
        }
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
