package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.Mood;

public class testFamiliarMood {
	
	private Familiar familiar;

	@Before
	public void setUp() throws Exception {
		familiar = new Cat("Filou");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * verifier que le familier ait bien le mood HAPPY
	 */
	@Test
	public void testMoodHappy() {
		familiar.setMoodValue(90);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.HAPPY, familiar.getMood());
	}
	
	/**
	 * verifier que le familier ait bien le mood JOYFUL
	 */
	@Test
	public void testMoodJoyful() {
		familiar.setMoodValue(75);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.JOYFUL, familiar.getMood());
	}
	
	/**
	 * verifier que le familier ait bien le mood FINE
	 */
	@Test
	public void testMoodFine() {
		familiar.setMoodValue(60);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.FINE, familiar.getMood());
	}
	
	/**
	 * verifier que le familier ait bien le mood SAD
	 */
	@Test
	public void testMoodSad() {
		familiar.setMoodValue(40);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.SAD, familiar.getMood());
	}
	
	/**
	 * verifier que le familier ait bien le mood MISERABLE
	 */
	@Test
	public void testModMiserable() {
		familiar.setMoodValue(10);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.MISERABLE, familiar.getMood());
	}

}
