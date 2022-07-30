package edu.school21.sockets.server;

import edu.school21.sockets.services.UsersService;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private UsersService usersService;
    private ServerSocket serverSocket;
    private String userName = null, userPassword = null;
    public Server(UsersService usersService) {
        this.usersService = usersService;
    }


    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        
    }
}
