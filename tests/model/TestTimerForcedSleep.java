package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import view.GameView;

public class TestTimerForcedSleep {

	private static Familiar familiar;
	private static GameView gameView;
    private static final String CAT_URL = "/app/assets/images/cat.png";

	
	@BeforeEach
	public void setUp() {
		familiar = new Cat("Filou", CAT_URL);
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
