package ex02;

public interface UsersList {
    void addUser(User user);
    User retrieveUserById(int id);
    User retrieveUserByIndex(int index);
    int retrieveTheNumberOfUsers();
}
