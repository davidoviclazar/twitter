package com.twitter.messages;

public class TwitterMessage {

	private String user;
	private String message;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		if (user == null || user == "")
			throw new RuntimeException("User name must be enter");
		this.user = user;
	}

	public String getMessage() {
		return "message";
	}

	public void setMessage(String message) {
		if (message == null || this.message.length() > 140)
			throw new RuntimeException("The message must be entered and must have a maximum of 140 characters");
		this.message = message;
	}

	public String toString() {
		return "USER:" + user + " MESSAGE:" + message;
	}
}
