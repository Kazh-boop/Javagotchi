package test.model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.Mood;
import app.model.Rooms;
import app.model.Weather;

class TestFamiliar {
	
    private static final int MAX_STATS = 100;
    private static final int TEST_HUNGRINESS = 50;
    private static final String CAT_NAME = "Filou";
    private static Familiar familiar;
    
    @BeforeEach
    public void initEach() {
    	familiar = new Cat(CAT_NAME);
    }
    
	@AfterEach
	public void cleanUpEach() {
		familiar = null;
	}
	
	private void setUpFeed() {
		familiar.setHungriness(TEST_HUNGRINESS);
		familiar.setRoom(Rooms.KITCHEN);
	}
	
	@Test
	public void newFamiliar() {
		Familiar familiar2 = new Cat(CAT_NAME);
		assertNotNull(familiar2);
	}
	
	@Test
	public void newFamiliarCopy( ){
		Cat familiar1 = new Cat(CAT_NAME);
		Cat familiar2 = new Cat(familiar1);
		assertEquals(familiar1, familiar2);
	}
	
//==========================================================================//
//																			//
//							TESTS ACCESSEURS								//
//																			//
//==========================================================================//

	@Test
	public void testGetPortions() {
		assertEquals(2, familiar.getPortions());
	}
	
	@Test
	public void testSetPortions() {
		familiar.setPortions(4);
		assertEquals(4, familiar.getPortions());
	}
	
	@Test
	public void testSetPortionsWrongValue() {
		familiar.setPortions(5);
		assertEquals(2, familiar.getPortions());
	}
	
	@Test
	public void testGetHappiness() {
		assertEquals(100, familiar.getHappiness());
	}
	
	@Test
	public void testSetHappiness() {
		familiar.setHappiness(5);
		assertEquals(5, familiar.getHappiness());
	}
	
	@Test
	public void testSetHappinessWrongValue() {
		familiar.setHappiness(150);
		assertEquals(100, familiar.getHappiness());
	}
	
	@Test
	public void testGetHygiene() {
		assertEquals(100, familiar.getHappiness());
	}
	
	@Test
	public void testSetHygiene() {
		familiar.setHygiene(5);
		assertEquals(5, familiar.getHygiene());
	}
	
	@Test
	public void testSetHygieneWrongValue() {
		familiar.setHygiene(150);
		assertEquals(100, familiar.getHygiene());
	}
	
	@Test
	public void testGetMood() {
		assertEquals(Mood.HAPPY, familiar.getMood());
	}
	
	@Test
	public void testSetMood() {
		familiar.setMood(Mood.JOYFUL);
		assertEquals(Mood.JOYFUL, familiar.getMood());
	}
		
	@Test
	public void testGetMoodCoef() {
		// Assert.assertEquals(expected, actual, delta)
		assertEquals(0.6, familiar.getMoodCoef(), 0.1);
	}
	
	@Test
	public void testGetFamiliarType() {
		assertEquals("Chat", familiar.getFamiliarType());
	}
	
	@Test
	public void testGetRooms() {
		assertEquals(Rooms.LIVING_ROOM, familiar.getRoom());
	}
	
	@Test
	public void testSetRooms() {
		familiar.setRoom(Rooms.KITCHEN);
		assertEquals(Rooms.KITCHEN, familiar.getRoom());
	}
	
	@Test
	public void testGetEnergy() {
		assertEquals(100, familiar.getEnergy());
	}
	
	@Test
	public void testSetEnergy() {
		familiar.setEnergy(5);
		assertEquals(5, familiar.getEnergy());
	}
	
	@Test
	public void testSetEnergyWrongValue() {
		familiar.setEnergy(150);
		assertEquals(100, familiar.getEnergy());
	}
	
	@Test
	public void testGetVitality() {
		assertEquals(100, familiar.getVitality());
	}
	
	@Test
	public void testSetVitality() {
		familiar.setVitality(5);
		assertEquals(5, familiar.getVitality());
	}
	
	@Test
	public void testGetName() {
		assertEquals(CAT_NAME, familiar.getName());
	}
	
	@Test
	public void testGetHungriness() {
		assertEquals(100, familiar.getHungriness());
	}
	
	@Test
	public void testSetHungriness() {
		familiar.setHungriness(5);
		assertEquals(5, familiar.getHungriness());
	}
	
	@Test
	public void testSetHungrinessWrongValue() {
		familiar.setHungriness(150);
		assertEquals(100, familiar.getHungriness());
	}
	
	@Test
	public void testToString() {
		assertEquals("Nom : Filou Type : Chat", familiar.toString());
	}
	
//==========================================================================//
//																			//
//								TESTS FEED									//
//																			//
//==========================================================================//

	@Test
	public void testFeed() {
		setUpFeed();
		familiar.feed(familiar.getRoom());
		assertEquals(85, familiar.getHungriness());
		assertEquals(95, familiar.getEnergy());
		assertEquals(95, familiar.getHygiene());
		assertEquals(1, familiar.getPortions());
	}
	
	 // Test nourrir familier quand les stats sont au max, pas de depassement de MAX_STATS
	@Test
	public void testFeedMaxStats() {
		setUpFeed();
		familiar.setHungriness(100);
		familiar.feed(familiar.getRoom());
		// pas de changement
		assertEquals(MAX_STATS, familiar.getHungriness());
	}
	
	@Test
	public void testFeedWrongPlace() {
		setUpFeed();
		familiar.setRoom(Rooms.LIVING_ROOM);
		familiar.feed(familiar.getRoom());
		// pas de changement
		assertEquals(TEST_HUNGRINESS, familiar.getHungriness());
		assertEquals(MAX_STATS, familiar.getEnergy());
		assertEquals(MAX_STATS, familiar.getHygiene());
		assertEquals(2, familiar.getPortions());
	}
	
	// Test nourrir familier quand il n'y a plus de portion
	@Test
	public void testFeedNoPortion() {
		setUpFeed();
		familiar.resetPortion();
		familiar.feed(familiar.getRoom());
		// pas de changement
		assertEquals(TEST_HUNGRINESS, familiar.getHungriness());
	}
	
	@Test
	public void testAddPortion() {
		familiar.resetPortion();
		familiar.addPortion();
		assertEquals(1, familiar.getPortions());
	}
	
	@Test
	public void testAddPortionWhenMax() {
		familiar.setPortions(4);
		familiar.addPortion();
		assertEquals(4, familiar.getPortions());
	}
	
//==========================================================================//
//																			//
//								TESTS MOOD									//
//																			//
//==========================================================================//
	
	@Test
	public void testMoodHappy() {
		familiar.setMoodValue(90);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.HAPPY, familiar.getMood());
	}
	
	@Test
	public void testMoodJoyful() {
		familiar.setMoodValue(75);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.JOYFUL, familiar.getMood());
	}
	
	@Test
	public void testMoodFine() {
		familiar.setMoodValue(60);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.FINE, familiar.getMood());
	}
	
	@Test
	public void testMoodSad() {
		familiar.setMoodValue(40);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.SAD, familiar.getMood());
	}
	
	@Test
	public void testModMiserable() {
		familiar.setMoodValue(10);
		familiar.setMood(familiar.changeMood());
		assertEquals(Mood.MISERABLE, familiar.getMood());
	}
	
	@Test
	public void testRecalculateMood() {
		familiar.recalculateMood(Weather.RAINY, Rooms.KITCHEN);
		assertEquals(Mood.JOYFUL, familiar.getMood());
	}
	
//==========================================================================//
//																			//
//								TESTS ROOMS									//
//																			//
//==========================================================================//
	
	@Test
	public void testMooveLeft() {
		familiar.moveLeft();
		assertEquals(Rooms.GARDEN, familiar.getRoom());
	}
	
	@Test
	public void testMooveRight() {
		familiar.moveRight();
		assertEquals(Rooms.KITCHEN, familiar.getRoom());
	}
	
}