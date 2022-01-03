package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.Mood;
import app.model.TimerVitality;

public class TestTimerVitality {

	private static Familiar familiar;
	
	@BeforeEach
	public void setUp() {
		familiar = new Cat("Filou");
	}
	
	@AfterEach
	public void tearDown() {
		familiar = null;
	}
	
	@Test
	public void testNewTimerVitality()
	{
		TimerVitality timerVitality = new TimerVitality(familiar, null);
		assertNotNull(timerVitality);
	}
	
	@Test
	public void testNewTimerVitalityPeriod()
	{
		TimerVitality timerVitality = new TimerVitality(familiar, null, 10);
		assertNotNull(timerVitality);
	}
	
	@Test
	public void testTimerGainVitality() throws InterruptedException {
		// on definit un timer avec une intervalle de 10ms
		/*
		familiar.setEnergy(100);
		familiar.setHygiene(100);
		familiar.setMood(Mood.HAPPY);
		familiar.setHungriness(100);
		*/
		familiar.setVitality(98);
		
		TimerVitality timerVitality = new TimerVitality(familiar, null, 10);
		timerVitality.run();
		Thread.sleep(20);
		assertEquals(100, familiar.getVitality());
	}
	
	//@Test
	public void testTimerLoseVitality() throws InterruptedException {
		// on definit un timer avec une intervalle de 10ms
		familiar.setEnergy(14);
		familiar.setHygiene(14);
		familiar.setMood(Mood.MISERABLE);
		familiar.setHungriness(14);
		familiar.setVitality(100);
		TimerVitality timerVitality = new TimerVitality(familiar, null, 10);
		timerVitality.run();
		Thread.sleep(20);
		assertEquals(98, familiar.getVitality());
	}

}
