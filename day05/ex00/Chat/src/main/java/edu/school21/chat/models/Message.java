package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Message {
    private long messageId;
    private String messageAuthor;
    private Chatroom messageRoom;
    private String messageText;
    private Date messageDateTime;

    public Message(long messageId, String messageAuthor, Chatroom messageRoom, String messageText, Date messageDateTime) {
        this.messageId = messageId;
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

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
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

    public Date getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(Date messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (messageId != message.messageId) return false;
        if (messageAuthor != null ? !messageAuthor.equals(message.messageAuthor) : message.messageAuthor != null)
            return false;
        if (messageRoom != null ? !messageRoom.equals(message.messageRoom) : message.messageRoom != null) return false;
        if (messageText != null ? !messageText.equals(message.messageText) : message.messageText != null) return false;
        return messageDateTime != null ? messageDateTime.equals(message.messageDateTime) : message.messageDateTime == null;
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
