package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import app.util.SoundManager;
import app.view.*;

public class MenuController implements ActionListener {
	
	private MainFrame mainFrame;
	private NewGameMenuController newGameMenuController;
	protected SaveMenuController saveMenuController;
	private MainMenu mainMenu;
	

	
    /**
     * Constructor
	 * Initializes the 3 Controller menus and the mainFrame,
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
	 * Empties the mainframe of all its components
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}
	
	/** 
	 * Reception of actions when clicking on buttons,
	 * Comparison of the source of the action and the different buttons,
	 * Execution of the corresponding action
	 * @param e
	 */
	@Override
    public void actionPerformed(ActionEvent e) {
		
		// JButton form MainMenu
        if(e.getSource() == this.mainMenu.getNewGame()) {
        	SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
        	newGameMenuController.newGameMenuDisplay();
        	
        }else if(e.getSource() == this.mainMenu.getSaves()) {
            try {
            	SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
				saveMenuController.savesMenuDisplay();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
        	
        }else if(e.getSource() == this.mainMenu.getQuit()) {
        	SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
        	System.exit(1);
        }
	}
	
	/**
	 * @return mainFrame
	 */
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}


}
