package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerPortions;

public class TestTimerPortions {
	
	private Familiar familiar;
	
	@BeforeEach
	public void setUp() {
		familiar = new Cat("Filou");
	}
	
	@AfterEach
	public void tearDown() {
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
