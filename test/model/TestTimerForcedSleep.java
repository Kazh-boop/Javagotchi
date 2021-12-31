package test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.TimerForcedSleep;
import app.view.GameView;

class TestTimerForcedSleep {

	private static Familiar familiar;
	private static GameView gameView;
	
	@BeforeAll
	public static void setUp() {
		familiar = new Cat("Filou");
	}
	
	@AfterAll
	public static void tearDown() {
		familiar = null;
	}
	
	@Test
	public void testNewTimerForcedSleep() {
		TimerForcedSleep timerForcedSleep = new TimerForcedSleep(familiar, 10, gameView);
		assertNotNull(timerForcedSleep);
	}

}
