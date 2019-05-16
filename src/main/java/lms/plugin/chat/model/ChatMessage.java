package lms.plugin.chat.model;

import java.util.Date;

public class ChatMessage {
    private MessageType type;
    private String content;
    private User sender;
    private Date timestamp;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
    
    

    public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

    
}
