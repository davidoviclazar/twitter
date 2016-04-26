package com.twitter.messages;

/**
 * It presents (it contains) the user data and input message
 * 
 * @author Lazar Davidovic
 *
 */
public class TwitterMessage {

	/**
	 * Name of the user (username) as String
	 */
	private String user;

	/**
	 * The content of message sent by the user as a String
	 */
	private String message;

	/**
	 * The method that return the value of attribute user
	 * 
	 * @return user Return information about the user who wrote the message
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Set a new value for attribute user (user name)
	 * 
	 * @param user
	 *            The user name
	 */
	public void setUser(String user) {
		if (user == null || user.equals(""))
			throw new RuntimeException("User name must be enter");
		this.user = user;
	}

	/**
	 * The method that return the value of the attribute message
	 * 
	 * @return message The message that is enter by the user
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the value of attribute message
	 * 
	 * @param message
	 *            User message
	 */
	public void setMessage(String message) {
		if (message == null || message.length() > 140)
			throw new RuntimeException("The message must be entered and must have a maximum of 140 characters");
		this.message = message;
	}

	/**
	 * Convert the object content to String
	 */
	public String toString() {
		return "USER:" + user + "MESSAGE:" + message;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterMessage other = (TwitterMessage) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
