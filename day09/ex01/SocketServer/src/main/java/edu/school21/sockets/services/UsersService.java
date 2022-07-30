package edu.school21.sockets.services;

import edu.school21.sockets.models.User;

public interface UsersService {
    void signUp(User user);
    boolean signIn(String username, String password);
    void saveMessage(String message);
}
