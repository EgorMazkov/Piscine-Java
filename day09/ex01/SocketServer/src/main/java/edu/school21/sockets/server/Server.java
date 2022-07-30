package edu.school21.sockets.server;

import edu.school21.sockets.models.User;
import edu.school21.sockets.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Server {
    private static UsersService usersService;
    private static PrintWriter writer;
    private Scanner reader;
    private ServerSocket serverSocket;
    private Socket socket;
    private List<Users> list = new ArrayList<>();

    @Autowired
    public Server(UsersService usersService) {
        Server.usersService = usersService;
    }

    public Server(Socket socket) {
        this.socket = socket;
    }

    public synchronized void start(int port) throws IOException {
        String signUpIn = null;
        serverSocket = new ServerSocket(port);
        while (true) {
            try {
                socket = serverSocket.accept();
                Users users = new Users(socket);
                list.add(users);
                System.out.println("Client connected");
                users.start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                stop();
            }
        }
    }

    private void stop() {
        try {
            if (reader != null) {
                reader.close();
            }

            if (writer != null) {
                writer.close();
            }

            if (socket != null) {
                socket.close();
            }

            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.exit(0);
    }

    private static class Users extends Thread {
        String signUpIn;
        private PrintWriter writer;
        private Scanner reader;
        private ServerSocket serverSocket;
        private Socket socket;
        private String message = null, username = null, password = null;

        public Users(Socket socket) {
            this.socket = socket;
            try {
                reader = new Scanner(socket.getInputStream());
                writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Hello from Server!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            if (reader.hasNextLine()) {
                message = reader.nextLine().trim();

                if (!"signUp".equalsIgnoreCase(message) && !"signIn".equalsIgnoreCase(message)) {
                    writer.println("Command not found!");
                }
                if (message.equals("signUp") || message.equals("signIn")) {
                    signUpIn = message;
                }
            }
            writer.println("Enter username: ");
            if (reader.hasNextLine()) {
                username = reader.nextLine().trim();
            }
            writer.println("Enter password: ");

            if (reader.hasNextLine()) {
                password = reader.nextLine().trim();
            }
            signUpIn(username, password, signUpIn);
            while (true) {
                try {
                    while (reader.hasNextLine()) {
                        message = reader.nextLine().trim();
                        if (message.equals("Exit")) {
                            writer.println(message);
                        }
                        usersService.saveMessage(message);
//                        list.stream().forEach(c -> c.writer.println(message));
                        writer.println(message);
                    }
                } catch (RuntimeException e) {
                    System.err.println(e.getMessage());
                    writer.println(e.getMessage());
                }
            }
        }

        private void signUpIn(String username, String password, String signUpIn) {
            if (signUpIn.equals("signUp")) {
                usersService.signUp(new User(username, password));
                writer.println("Successful!");
            } else if (signUpIn.equals("signIn")) {
                usersService.signIn(username, password);
                writer.println("Start messaging");
            }
        }
    }
}
