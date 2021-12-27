package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerEnergy;

public class TestTimerEnergy {
	
	Familiar familiar;
	
	@Before
	public void setUp() throws Exception {
		this.familiar = new Cat("Filou");
	}
	
	@After
	public void tearDown() throws Exception {
		this.familiar = null;
	}
	
	@Test
	public void testNewTimerEnergy()
	{
		TimerEnergy timerEnergy = new TimerEnergy(this.familiar);
		assertNotNull(timerEnergy);
	}
	
	@Test
	public void testNewTimerEnergyPeriod()
	{
		TimerEnergy timerEnergy = new TimerEnergy(this.familiar, 10);
		assertNotNull(timerEnergy);
	}
	
	@Test
	public void testTimerLoseEnergy() throws InterruptedException {
		// on definit un timer avec une intervalle de 10ms
		TimerEnergy timerEnergy = new TimerEnergy(this.familiar, 10);
		timerEnergy.run();
		Thread.sleep(50);
		assertEquals(95, this.familiar.getEnergy());
	}
}
