package app.util;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {

    public static final String SOUNDS_MENU_CLICK = "app/assets/sounds/click.wav";
	public static final String SOUNDS_DOOR = "app/assets/sounds/door.wav";
	public static final String SOUNDS_SAVE = "app/assets/sounds/save.wav";
	public static final String SOUNDS_EAT_FOOD = "app/assets/sounds/eat_0.wav";
	public static final String SOUNDS_EAT_CHARGE = "app/assets/sounds/eat_1.wav";
	public static final String SOUNDS_LAUNCH = "app/assets/sounds/launch.wav";
	
    private SoundManager() { }
    
    /**
     * Start a song with default volume
     * @param path
     */
	public static void playsound(String path) {
		playsound(path,20f);
	}
	
	/**
	 * Start a song with defined volume
	 * @param path
	 */
	public static void playsound(String path, float volume) {
		try {
			Clip clip = AudioSystem.getClip();

			clip.open(AudioSystem.getAudioInputStream(new File(path)));
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-volume);
            clip.setFramePosition(0);
            clip.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
}
