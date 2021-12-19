package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;

public class testTimer {
	
	private Familiar familiar;
	private static final long ONE_SECOND = 1000;
	private static final long WAIT = 5000;

	@BeforeEach
	void setUp() throws Exception {
		this.familiar = new Cat("Filou", ONE_SECOND);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * test d'ajout des portions dans le temps
	 * ajout d'une portion chaque seconde 
	 * Attente de 5 secondes
	 * 
	 * @throws InterruptedException
	 */
	@Test
	void timerAddPortion() throws InterruptedException {
		familiar.ResetPortion();
		familiar.getTimerPortion().start();
		Thread.sleep(WAIT);
		assertEquals(4, familiar.getPortions());
	}
	
	/**
	 * test de perte d'energie du familier dans le temps
	 * perte de 1 energie chaque seconde
	 * Attente de 5 seconde
	 * @throws InterruptedException
	 */
	@Test
	void timerLoseEnergy() throws InterruptedException {
		familiar.getTimerEnergy().start();
		Thread.sleep(WAIT);
		assertEquals(95, familiar.getEnergy());
	}
	
	

}
