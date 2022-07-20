package ex04;

import ex04.User;

public interface UsersList {
    void addUser(User user);
    User retrieveUserById(int id);
    User retrieveUserByIndex(int index);
    int retrieveTheNumberOfUsers();
    public int getNumberUsers();
}
