package edu.school21.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static Socket socket;
    private static PrintWriter writer;
    private static Scanner reader;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int port;
        if (args.length != 1 || !args[0].startsWith("--server-port=")) {
            System.err.println("<--server-port=>");
            System.exit(-1);
        }
        port = Integer.parseInt(args[0].substring(14));
        Client client = new Client(port);
    }

    private static class Client {

        public Client(int port) throws IOException {
            socket = new Socket("127.0.0.1", port);
            reader = new Scanner(socket.getInputStream());
            writer = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                if (reader.hasNextLine()) {
                    String message = reader.nextLine();
                    System.out.println(message);

                    if ("Successful!".equalsIgnoreCase(message)) {
                        stop();
                    }
                }
                if (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    writer.println(message);
                }
            }
        }

        private void stop() {
            try {
                reader.close();
                writer.close();
                scanner.close();
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            System.exit(0);
        }
    }
}
