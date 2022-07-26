package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private long messageId;
    private User messageAuthor;
    private Chatroom messageRoom;
    private String messageText;
    private LocalDateTime messageDateTime;

    public Message(Long messageId, User messageAuthor, Chatroom messageRoom, String messageText, LocalDateTime messageDateTime) {
        if (messageId == null) {
            this.messageId = 100;
        } else {
            this.messageId = messageId;
        }
        this.messageAuthor = messageAuthor;
        this.messageRoom = messageRoom;
        this.messageText = messageText;
        this.messageDateTime = messageDateTime;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public User getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public Chatroom getMessageRoom() {
        return messageRoom;
    }

    public void setMessageRoom(Chatroom messageRoom) {
        this.messageRoom = messageRoom;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalDateTime getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(LocalDateTime messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return messageId == message.messageId && messageAuthor.equals(message.messageAuthor) && messageRoom.equals(message.messageRoom) && messageText.equals(message.messageText) && messageDateTime.equals(message.messageDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageAuthor, messageRoom, messageText, messageDateTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageAuthor='" + messageAuthor + '\'' +
                ", messageRoom=" + messageRoom +
                ", messageText='" + messageText + '\'' +
                ", messageDateTime=" + messageDateTime +
                '}';
    }
}
