package com.twitter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.messages.TwitterMessage;

public class TwitterTest {
	Twitter tw;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	@Test
	public void testInput() {
		tw.input("User1", "Hello, I am User1!");
		TwitterMessage tp = new TwitterMessage();
		tp.setUser("User1");
		tp.setMessage("Hello, I am User1!");
		assertEquals(tw.returnAllMessages().getLast(), tp);

	}

	@Test
	public void testReturnMessages() {
		tw.input("User1", "Hello, I am User1!");
		tw.input("User2", "Hello, I am User1!");
		tw.input("User3", "Hello, I am User3!");
		tw.input("User4", "Hello, I am User4!");
		TwitterMessage[] messages = tw.returnMessages(0, "User1!");
		int br = 0;
		for (int i = 0; i < messages.length; i++)
			if (messages[i] != null)
				br++;
			else
				break;
		assertTrue(br == 2);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testReturnMessagesTagIsNull() {
		tw.returnMessages(10, null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testReturnMessagesTagIsEmptyString() {
		tw.returnMessages(10, new String(""));
	}

	@Test
	public void testReturnMessagesNumberIsZero() {
		tw.input("User1", "Hello, I am User1!");
		tw.input("User2", "Hello, I am User1!");
		tw.input("User3", "Hello, I am User3!");
		tw.input("User4", "Hello, I am User4!");
		TwitterMessage[] messages = tw.returnMessages(0, "User1!");
		int br = 0;
		for (int i = 0; i < messages.length; i++)
			if (messages[i] != null)
				br++;
			else
				break;
		assertTrue(br == 2);

	}

}
