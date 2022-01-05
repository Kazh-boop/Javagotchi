package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestTimerEnergy {
	
	private static Familiar familiar;
    private static final String CAT_URL = "/app/assets/images/cat.png";

	
	@BeforeAll
	public static void setUp() throws Exception {
		familiar = new Cat("Filou", CAT_URL);
	}
	
	@AfterAll
	public static void tearDown() throws Exception {
		familiar = null;
	}
	
	@Test
	public void testNewTimerEnergy()
	{
		TimerEnergy timerEnergy = new TimerEnergy(familiar, null);
		assertNotNull(timerEnergy);
	}
	
	@Test
	public void testNewTimerEnergyPeriod()
	{
		TimerEnergy timerEnergy = new TimerEnergy(familiar, null, 10);
		assertNotNull(timerEnergy);
	}
	
	@Test
	public void testTimerLoseEnergy() throws InterruptedException {
		// on definit un timer avec une intervalle de 10ms
		TimerEnergy timerEnergy = new TimerEnergy(familiar, null, 10);
		timerEnergy.run();
		Thread.sleep(50);
		assertEquals(95, familiar.getEnergy());
	}
}
