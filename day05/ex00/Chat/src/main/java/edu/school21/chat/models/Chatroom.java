package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private long chatRoomId;
    private String chatRoomName;
    private User chatRoomOwner;
    private List<Message> listMessage;

    public Chatroom(long chatRoomId, String chatRoomName, User chatRoomOwner, List<Message> listMessage) {
        this.chatRoomId = chatRoomId;
        this.chatRoomName = chatRoomName;
        this.chatRoomOwner = chatRoomOwner;
        this.listMessage = listMessage;
    }

    public long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }


    public User getChatRoomOwner() {
        return chatRoomOwner;
    }

    public void setChatRoomOwner(User chatRoomOwner) {
        this.chatRoomOwner = chatRoomOwner;
    }

    public List<Message> getListMessage() {
        return listMessage;
    }

    public void setListMessage(List<Message> listMessage) {
        this.listMessage = listMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chatroom)) return false;

        Chatroom chatroom = (Chatroom) o;

        return chatRoomId == chatroom.chatRoomId && chatRoomName.equals(chatroom.chatRoomName) && chatRoomOwner.equals(chatroom.chatRoomOwner) && listMessage.equals(chatroom.listMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatRoomId, chatRoomName, chatRoomOwner, listMessage);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "chatRoomId=" + chatRoomId +
                ", chatRoomName='" + chatRoomName + '\'' +
                ", chatRoomOwner=" + chatRoomOwner +
                ", listMessage=" + listMessage +
                '}';
    }
}
