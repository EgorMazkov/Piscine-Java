package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private long userId;
    private String login;
    private String password;
    private List<Chatroom> createRoomList;
    private List<Chatroom> chatList;

    public User(long userId, String login, String password, List<Chatroom> createRoomList, List<Chatroom> chatList) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.createRoomList = createRoomList;
        this.chatList = chatList;
    }

    public User(long userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getRoomList() {
        return createRoomList;
    }

    public void setRoomList(List<Chatroom> createRoomList) {
        this.createRoomList = createRoomList;
    }

    public List<Chatroom> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chatroom> chatList) {
        this.chatList = chatList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return createRoomList.equals(user.createRoomList) && userId == user.userId && login.equals(user.login) && password.equals(user.password) && chatList.equals(user.chatList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, createRoomList, chatList);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
