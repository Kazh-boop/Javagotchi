package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerHungriness;

public class TestTimerHungriness {

	private static Familiar familiar;
    private static final String CAT_URL = "/app/assets/images/cat.png";

	
	@BeforeEach
	public void setUp() {
		familiar = new Cat("Filou", CAT_URL);
	}
	
	@AfterEach
	public void tearDown() {
		familiar = null;
	}
	
	@Test
	public void testNewTimerHungriness() {
		TimerHungriness timerHungriness = new TimerHungriness(familiar, null, null);
		assertNotNull(timerHungriness);
	}
	
	@Test
	public void testNewTimerHungrinessPeriod() {
		TimerHungriness timerHungriness = new TimerHungriness(familiar, null, null, 10);
		assertNotNull(timerHungriness);
	}
	
	@Test
	public void timerLoseSatiety() throws InterruptedException {
		TimerHungriness timerHungriness = new TimerHungriness(familiar, null, null, 10);
		timerHungriness.run();
		Thread.sleep(50);
		assertEquals(95, familiar.getHungriness());
	}

}