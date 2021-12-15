package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import app.view.*;

public class MenuController implements ActionListener {
	
	private MainFrame mainFrame;
	private MainMenu mainMenu;
	private NewGameMenu newGameMenu;
	private SavesMenu savesMenu;
	
	private final int CURSOR_MAX = 3;
	private final int CURSOR_MIN = 0;
	private int cursorImage = 0;
	private final String[] familiarType = {"Cat", "Dog", "Robot", "Rabbit"};
	private final String[] familiarTypeURL = {"../image/cat.png", "../image/dog.png", "../image/robot.png", "../image/rabbit.png"};
	
	public MenuController() {
		this.mainFrame = new MainFrame();
		this.mainMenu = new MainMenu(mainFrame);
		this.newGameMenu = new NewGameMenu(mainFrame);
		this.savesMenu = new SavesMenu(mainFrame);
		
		firstMainMenuDisplay();
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		
		// JButton form MainMenu
        if(e.getSource() == this.mainMenu.getNewGame()) {
        	newGameMenuDisplay();
        	
        }else if(e.getSource() == this.mainMenu.getSaves()) {
            savesMenuDisplay();
        	
        }else if(e.getSource() == this.mainMenu.getQuit()) {
        	System.exit(1);
        
        // JButton from newGameMenu
        }else if(e.getSource() == this.newGameMenu.getBackMenu()) {
			mainMenuDisplay();
			
        }else if(e.getSource() == this.newGameMenu.getLeftFamiliarType()) {
        	turnLeftFamiliar();
        	
        }else if(e.getSource() == this.newGameMenu.getRightFamiliarType()) {
        	turnRightFamiliar();
        	
        }else if(e.getSource() == this.newGameMenu.getLaunchGame()) {
			

        // JButton from savesMenu        	
        }else if(e.getSource() == this.savesMenu.getBackMenu()) {
			mainMenuDisplay();
        }
    }
	
	private void turnRightFamiliar() {
		if(cursorImage < CURSOR_MAX) {
			cursorImage++;
		}else{
			cursorImage = CURSOR_MIN;
		}
			this.newGameMenu.getSpeciesIcon().setIcon(createImageIcon(familiarTypeURL[cursorImage]));
		}

	private void turnLeftFamiliar() {
	if(cursorImage > CURSOR_MIN) {
		cursorImage--;
	}else{
		cursorImage = CURSOR_MAX;
	}
		this.newGameMenu.getSpeciesIcon().setIcon(createImageIcon(familiarTypeURL[cursorImage]));
	}

	public void firstMainMenuDisplay() {
		mainMenu.display(this);
	}
	
	public void mainMenuDisplay() {
		mainFrame = flush(mainFrame);
		mainMenu.display(this);
	}
	
	public void newGameMenuDisplay() {
		mainFrame = flush(mainFrame);
		newGameMenu.display(this);
	}
	
	public void savesMenuDisplay() {
		mainFrame = flush(mainFrame);
		savesMenu.display(this);
	}
	
	private MainFrame flush(MainFrame nFrame) {
		nFrame.getContentPane().removeAll();
		nFrame.repaint();
		return nFrame;
	}
	
	private static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = NewGameMenu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
