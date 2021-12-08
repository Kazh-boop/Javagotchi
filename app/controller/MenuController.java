package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.*;

public class MenuController implements ActionListener {
	
	private MainFrame mainFrame;
	private MainMenu mainMenu;
	private NewGameMenu newGameMenu;
	private SavesMenu savesMenu;
	
	public MenuController() {
		this.mainFrame = new MainFrame();
		this.mainMenu = new MainMenu();
		this.newGameMenu = new NewGameMenu();
		this.savesMenu = new SavesMenu();
		
		firstMainMenuDisplay(this.mainFrame);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		
		// JButton form MainMenu
        if(e.getSource() == this.mainMenu.getNewGame()) {
        	newGameMenuDisplay(this.mainFrame);
        	
        }else if(e.getSource() == this.mainMenu.getSaves()) {
            savesMenuDisplay(this.mainFrame);
        	
        }else if(e.getSource() == this.mainMenu.getQuit()) {
        	System.exit(1);
        
        // JButton from newGameMenu
        }else if(e.getSource() == this.newGameMenu.getBackMenu()) {
			mainMenuDisplay(this.mainFrame);
			
        }else if(e.getSource() == this.newGameMenu.getLeftFamiliar()) {
            
        	
        }else if(e.getSource() == this.newGameMenu.getRightFamiliar()) {
            
        }else if(e.getSource() == this.newGameMenu.getLaunchGame()) {
        	System.exit(1);
        	
        // JButton from savesMenu        	
        }else if(e.getSource() == this.savesMenu.getBackMenu()) {
			mainMenuDisplay(this.mainFrame);
        }
    }
	
	public void firstMainMenuDisplay(MainFrame nFrame) {
		this.mainFrame = nFrame;
		mainMenu.display(this,mainFrame);
	}
	
	public void mainMenuDisplay(MainFrame nFrame) {
		this.mainFrame = nFrame;
		mainFrame = hide(mainFrame);
		mainMenu.display(this,mainFrame);
	}
	
	public void newGameMenuDisplay(MainFrame nFrame) {
		this.mainFrame = nFrame;
		mainFrame = hide(mainFrame);
		newGameMenu.display(this,mainFrame);
	}
	
	public void savesMenuDisplay(MainFrame nFrame) {
		this.mainFrame = nFrame;
		mainFrame = hide(mainFrame);
		savesMenu.display(this,mainFrame);
	}
	
	private MainFrame hide(MainFrame nFrame) {
		nFrame.removeAll();
		nFrame.setEnabled(true);
		nFrame.setVisible(true);
		return nFrame;
	}
}
