package test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerForcedSleep;
import app.view.GameView;

class TestTimerForcedSleep {

	private static Familiar familiar;
	private static GameView gameView;
	
	@BeforeEach
	public void setUp() {
		familiar = new Cat("Filou");
	}
	
	@AfterEach
	public void tearDown() {
		familiar = null;
	}
	
	@Test
	public void testNewTimerForcedSleep() {
		TimerForcedSleep timerForcedSleep = new TimerForcedSleep(familiar, 10, gameView);
		assertNotNull(timerForcedSleep);
	}

}
