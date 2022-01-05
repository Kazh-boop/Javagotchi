package app.util;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * enumeration to know the different sounds that can be played during the game
 */

public enum SoundManager {
    SOUNDS_MENU_CLICK("app/assets/sounds/click.wav"),
	SOUNDS_DOOR("app/assets/sounds/door.wav"),
	SOUNDS_SAVE("app/assets/sounds/save.wav"),
	SOUNDS_EAT_FOOD("app/assets/sounds/eat_0.wav"),
	SOUNDS_EAT_CHARGE("app/assets/sounds/eat_1.wav"),
	SOUNDS_LAUNCH("app/assets/sounds/launch.wav");

    private String url;
    
    /**
     * Constructor
     * @param url
     */
    private SoundManager(String url) {
    	this.url = url;
    }
    
    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * Start a song with default volume
     * @param sound
     */
	public static void playsound(SoundManager sound) {
		playsound(sound,20f);
	}
	
	/**
	 * Start a song with defined volume
	 * @param sound
	 * @param volume
	 */
	public static void playsound(SoundManager sound, float volume) {
		String path = sound.getUrl();
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
