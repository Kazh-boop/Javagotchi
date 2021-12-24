package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import app.view.*;

public class MenuController implements ActionListener {
	
	private MainFrame mainFrame;
	private NewGameMenuController newGameMenuController;
	protected SaveMenuController saveMenuController;
	private MainMenu mainMenu;
	
	private static final String SOUNDS_MENU_CLICK = "../assets/sounds/click.wav";
	
    /**
	 * Initialise les 3 controller des menu ainsi que la mainFrame,
	 * Affiche le menu principal
	 */
	public MenuController() {
		this.mainFrame = new MainFrame();
		this.newGameMenuController = new NewGameMenuController(this, mainFrame);
		this.saveMenuController = new SaveMenuController(this, mainFrame);
		
		this.mainMenu = new MainMenu(this);
		mainMenuDisplay();
	}
	
	/**
	 * Affiche le menu principal sur la mainFrame
	 */
	public void mainMenuDisplay() {
		flush();
		mainMenu.display(this);
	}
	
	/** 
	 * Vide la mainFrame de tous ses composants
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}
	
	/** 
	 * Reception des actions lors de clics sur des boutons,
	 * Comparaison de la source de l'action et des differents boutons,
	 * Execution de l'action correspondante
	 * @param e ActionEvent
	 */
	@Override
    public void actionPerformed(ActionEvent e) {
		
		// JButton form MainMenu
        if(e.getSource() == this.mainMenu.getNewGame()) {
        	playsound(SOUNDS_MENU_CLICK);
        	newGameMenuController.newGameMenuDisplay();
        	
        }else if(e.getSource() == this.mainMenu.getSaves()) {
            try {
            	playsound(SOUNDS_MENU_CLICK);
				saveMenuController.savesMenuDisplay();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
        	
        }else if(e.getSource() == this.mainMenu.getQuit()) {
        	playsound(SOUNDS_MENU_CLICK);
        	System.exit(1);
        }
	}
	
	protected void playsound(String path) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path)));
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-20.0f);
            clip.setFramePosition(0);
            clip.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Donne la mainFrame
	 * @return mainFrame MainFrame
	 */
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}

	public String getClickSound() {
		return MenuController.SOUNDS_MENU_CLICK;
	}
}
