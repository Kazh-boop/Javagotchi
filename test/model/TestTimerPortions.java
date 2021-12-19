package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerPortions;;

public class TestTimerPortions {
	private Familiar familiar;
	private TimerPortions timerPortions;

	@Before
	public void setUp() throws Exception {
		this.familiar = new Cat("Filou");
		// creation d'un timer avec une periode de 10ms
		this.timerPortions = new TimerPortions(this.familiar, 10);
	}
	
	@After
	public void tearDown() throws Exception {
		this.familiar = null;
		this.timerPortions = null;
	}
	
	@Test
	public void timerAddPortion() throws InterruptedException {
		familiar.ResetPortion();
		this.timerPortions.run();
		Thread.sleep(50);
		assertEquals(4, familiar.getPortions());
	}
}
