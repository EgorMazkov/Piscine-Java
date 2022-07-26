package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.JdbcDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Scanner;


public class Program {
    private static final String EXIT = "exit";

    private static long id;

    public static void main(String[] args) {
        JdbcDataSource dataSource = new JdbcDataSource();

        updateData("src/main/resources/data.sql", dataSource);
        updateData("src/main/resources/schema.sql", dataSource);

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource.getDataSource());
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Enter a message ID");
            String str = scanner.nextLine();


            if (EXIT.equals(str)) {
                System.exit(0);
            }

            try {
                id = Long.parseLong(str);
            } catch (NumberFormatException e) {
                System.out.println("The entered text is not 'exit' and not numbers");
                continue;
            }
            Optional<Message> message = repository.findById(id);

            if (message != null && message.isPresent()) {
                System.out.println(message.get());
            } else {
                System.out.println("id not found");
            }
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
