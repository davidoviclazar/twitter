package com.twitter;

import java.util.LinkedList;

import com.twitter.messages.TwitterMessage;

public class Twitter {

	private LinkedList<TwitterMessage> messages = new LinkedList<TwitterMessage>();

	public LinkedList<TwitterMessage> returnAllMessages() {
		return messages;
	}

	public void input(String user, String message) {
		// Create a new message and the full data
		TwitterMessage twitterMessage = new TwitterMessage();
		twitterMessage.setUser("User");
		twitterMessage.setMessage(message);
		// The message is entered in the list at the end
		messages.addLast(twitterMessage);
	}

	public TwitterMessage[] returnMessages(int maxNumber, String tag) {
		if (tag == null || tag == "")
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
					result[counter + 1] = messages.get(i);
					counter++;
				} else
					break;
		return result;
	}
}
