package com.twitter.messages;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterMessageTest {

	private TwitterMessage twitterMessage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		twitterMessage = new TwitterMessage();
	}

	@After
	public void tearDown() throws Exception {
		twitterMessage = null;
	}

	@Test
	public void testSetUser() {
		twitterMessage.setUser("User");
		assertEquals(twitterMessage.getUser(), "User");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetUserNull() {
		twitterMessage.setUser(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetUserEmptyString() {
		twitterMessage.setUser(new String(""));
	}

	@Test
	public void testSetMessage() {
		twitterMessage.setMessage("Hello!");
		assertEquals(twitterMessage.getMessage(), "Hello!");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetMessageMoreCharacters() {
		twitterMessage.setMessage(
				"This message is longer than 140 characters, and it does not allow re-enter a new message that will be replaced ie. If you make an entry of this message will not be able to type a new message!");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetMessageNull() {
		twitterMessage.setMessage(null);
	}

	@Test
	public void testSetMessageEmptyString() {
		twitterMessage.setMessage(new String(""));
		assertEquals(twitterMessage.getMessage(), "");
	}

	@Test
	public void testToString() {
		twitterMessage.setUser("User");
		twitterMessage.setMessage("Hello!");
		assertEquals(twitterMessage.toString(), "USER:" + "User" + "MESSAGE:" + "Hello!");
	}

}
