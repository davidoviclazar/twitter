package com.twitter;

import java.util.LinkedList;

import com.twitter.messages.TwitterMessage;

public class Twitter {

	private LinkedList<TwitterMessage> messages = new LinkedList<TwitterMessage>();

	/**
	 * Return a list of all enter messages
	 * 
	 * @return messages User messages
	 */
	public LinkedList<TwitterMessage> returnAllMessages() {
		return messages;
	}

	/**
	 * Enter the user and his message in the message list
	 * 
	 * @param user
	 *            User who wrote the message
	 * @param message
	 *            User message
	 */
	public void input(String user, String message) {
		// Create a new message and the full data
		TwitterMessage twitterMessage = new TwitterMessage();
		twitterMessage.setUser(user);
		twitterMessage.setMessage(message);
		// The message is entered in the list at the end
		messages.addLast(twitterMessage);
	}

	/**
	 * Return a array of messages that contain a specific tag, taking into
	 * account the matches
	 * 
	 * @param maxNumber
	 *            Maximum number of messages that are returned as a result, and
	 *            in which there is a match with entered tag
	 * @param tag
	 *            String whose value is search in messages
	 * @return result A array of messages that contain forwarded tag
	 */
	public TwitterMessage[] returnMessages(int maxNumber, String tag) {
		if (tag == null || tag.equals(""))
			throw new RuntimeException("You must enter a tag");
		// If maxNumber <= 0, maxNumber is set to 100 messages
		if (maxNumber <= 0)
			maxNumber = 100;
		// Extra variable that represents the counter enrolled messages
		int counter = 0;
		// Extra String representing the search result
		TwitterMessage[] result = new TwitterMessage[maxNumber];
		// Search the messages that contain the tag
		// If you find any such, if not exceeded maxNumber it is insert into a
		// array. If maxNumber exceeded, the search is interrupt.
		for (int i = 0; i < messages.size(); i++)
			if (messages.get(i).getMessage().indexOf(tag) != -1)
				if (counter < maxNumber) {
					result[counter++] = messages.get(i);
				} else
					break;
		return result;
	}
}
