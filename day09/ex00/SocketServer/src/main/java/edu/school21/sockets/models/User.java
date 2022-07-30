package edu.school21.sockets.models;

public class User {
    private Long id;
    private String userName;
    private String userPassword;

    public User(Long id, String userName, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Long getId() {
        return id;
    }

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return userName;
    }

    public void setClientName(String userName) {
        this.userName = userName;
    }

    public String getClientPassword() {
        return userPassword;
    }

    public void setClientPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
