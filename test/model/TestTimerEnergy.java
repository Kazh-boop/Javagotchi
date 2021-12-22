package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerEnergy;

public class TestTimerEnergy {
	
	private Familiar familiar;
	private TimerEnergy timerEnergy;
	
	@Before
	public void setUp() throws Exception {
		this.familiar = new Cat("Filou");
		// creation d'un timer avec une periode de 10ms
		this.timerEnergy = new TimerEnergy(this.familiar, 10);
	}
	
	@After
	public void tearDown() throws Exception {
		this.familiar = null;
		this.timerEnergy = null;
	}
	
	@Test
	public void timerLoseEnergy() throws InterruptedException {
		this.timerEnergy.run();
		Thread.sleep(50);
		assertEquals(95, this.familiar.getEnergy());
	}
}
