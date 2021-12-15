package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.Rooms;

public class testFamiliarFeed {

	private Familiar familiar;
	private Rooms currentRoom;
    private static final int MAX_STATS = 100;
    private static final int TEST_HUNGRINESS = 50;
	

	@Before
	public void setUp() throws Exception {
		familiar = new Cat("Filou");
		currentRoom = Rooms.KITCHEN;
		familiar.setHungriness(TEST_HUNGRINESS);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test nourrir familier quand les conditions sont reunis
	 */
	@Test
	public void feed() {
		familiar.feed(currentRoom);
		assertEquals(85, familiar.getHungriness());
		assertEquals(95, familiar.getEnergy());
		assertEquals(95, familiar.getHygiene());
		assertEquals(1, familiar.getPortions());
	}
	
	/**
	 * Test nourrir familier quand les stats sont au max, pas de depassement de MAX_STATS
	 */
	@Test
	public void feedMaxStats() {
		familiar.setHungriness(99);
		familiar.feed(currentRoom);
		// pas de changement
		assertEquals(MAX_STATS, familiar.getHungriness());
	}
	
	/**
	 * Test nourrir familier quand celui-ci n'est pas dans la cuisine
	 */
	@Test
	public void feedNotKitchen() {
		this.currentRoom = Rooms.LIVING_ROOM;
		familiar.feed(currentRoom);
		// pas de changement
		assertEquals(TEST_HUNGRINESS, familiar.getHungriness());
		assertEquals(MAX_STATS, familiar.getEnergy());
		assertEquals(MAX_STATS, familiar.getHygiene());
		assertEquals(2, familiar.getPortions());
	}
	
	
	/**
	 * Test nourrir familier quand il n'y a plus de portion
	 */
	@Test
	public void feedNoPortion() {
		familiar.ResetPortion();
		familiar.feed(currentRoom);
		// pas de changement
		assertEquals(TEST_HUNGRINESS, familiar.getHungriness());
	}
	

}
