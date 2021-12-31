package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerHungriness;

public class TestTimerHungriness {

	private static Familiar familiar;
	
	@BeforeAll
	public static void setUp() {
		familiar = new Cat("Filou");
	}
	
	@AfterAll
	public static void tearDown() {
		familiar = null;
	}
	
	@Test
	public void testNewTimerHungriness() {
		TimerHungriness timerHungriness = new TimerHungriness(this.familiar);
		assertNotNull(timerHungriness);
	}
	
	@Test
	public void testNewTimerHungrinessPeriod() {
		TimerHungriness timerHungriness = new TimerHungriness(this.familiar, 10);
		assertNotNull(timerHungriness);
	}
	
	@Test
	public void timerLoseSatiety() throws InterruptedException {
		TimerHungriness timerHungriness = new TimerHungriness(this.familiar, 10);
		timerHungriness.run();
		Thread.sleep(50);
		assertEquals(95, familiar.getHungriness());
	}

}
