package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerPortions;;

public class TestTimerPortions {
	
	private static Familiar familiar;
	
	@BeforeAll
	public void setUp() {
		familiar = new Cat("Filou");
	}
	
	@AfterAll
	public static void tearDown() {
		familiar = null;
	}
	
	@Test
	public void testNewTimerPortions()
	{
		TimerPortions timerPortions = new TimerPortions(this.familiar);
		assertNotNull(timerPortions);
	}
	
	@Test
	public void testNewTimerPortionsPeriod()
	{
		TimerPortions timerPortions = new TimerPortions(this.familiar, 10);
		assertNotNull(timerPortions);
	}
	
	@Test
	public void timerAddPortion() throws InterruptedException {
		familiar.resetPortion();
		TimerPortions timerPortions = new TimerPortions(this.familiar, 10);
		timerPortions.run();
		Thread.sleep(50);
		assertEquals(4, familiar.getPortions());
	}
}
