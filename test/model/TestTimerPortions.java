package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerPortions;;

public class TestTimerPortions {
	private Familiar familiar;
	
	@Before
	public void setUp() throws Exception {
		this.familiar = new Cat("Filou");
	}
	
	@After
	public void tearDown() throws Exception {
		this.familiar = null;
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
		familiar.ResetPortion();
		TimerPortions timerPortions = new TimerPortions(this.familiar, 10);
		timerPortions.run();
		Thread.sleep(50);
		assertEquals(4, familiar.getPortions());
	}
}
