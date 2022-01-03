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
	 * initializes the 3 Controller menus and the mainFrame,
	 * displays the main menu
	 */
	public MenuController() {
		this.mainFrame = new MainFrame();
		this.newGameMenuController = new NewGameMenuController(this, mainFrame);
		this.saveMenuController = new SaveMenuController(this, mainFrame);
		
		this.mainMenu = new MainMenu(this);
		mainMenuDisplay();
	}
	
	/**
	 * Displays the main menu on the MainFrame
	 */
	public void mainMenuDisplay() {
		flush();
		mainMenu.display(this);
	}
	
	/** 
	 * empties the mainframe of all its components
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}
	
	/** 
	 * reception of actions when clicking on buttons,
	 * Comparison of the source of the action and the different buttons,
	 * execution of the corresponding action
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
	
	/**
	 * method for starting the sound clip
	  */
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
	 * 
	 * Give the mainFrame
	 * @return mainFrame MainFrame
	 */
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}

	/**
	 * return the sound to make when clicked
	 */
	public String getClickSound() {
		return MenuController.SOUNDS_MENU_CLICK;
	}
}
