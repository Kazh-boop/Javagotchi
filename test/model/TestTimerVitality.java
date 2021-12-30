package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerVitality;

public class TestTimerVitality {

	Familiar familiar;
	
	@BeforeAll
	public void setUp() {
		this.familiar = new Cat("Filou");
	}
	
	@AfterAll
	public void tearDown() {
		this.familiar = null;
	}
	
	@Test
	public void testNewTimerVitality()
	{
		TimerVitality timerVitality = new TimerVitality(this.familiar);
		assertNotNull(timerVitality);
	}
	
	@Test
	public void testNewTimerVitalityPeriod()
	{
		TimerVitality timerVitality = new TimerVitality(this.familiar, 10);
		assertNotNull(timerVitality);
	}
	
	@Test
	public void testTimerGainVitality() throws InterruptedException {
		// on definit un timer avec une intervalle de 10ms
		familiar.setVitality(98);
		TimerVitality timerVitality = new TimerVitality(this.familiar, 10);
		timerVitality.run();
		Thread.sleep(20);
		assertEquals(100, this.familiar.getVitality());
	}
	
	@Test
	public void testTimerLoseVitality() throws InterruptedException {
		// on definit un timer avec une intervalle de 10ms
		familiar.setEnergy(14);
		familiar.setHygiene(14);
		familiar.setHappiness(14);
		familiar.setHungriness(14);
		familiar.setVitality(100);
		TimerVitality timerVitality = new TimerVitality(this.familiar, 10);
		timerVitality.run();
		Thread.sleep(20);
		assertEquals(98, this.familiar.getVitality());
	}

}
