package app.controller;

import app.model.Familiar;
import app.model.Room;
import app.model.Rooms;
import app.model.SaveManager;

import app.model.TimerSleep;
import app.model.TimerEnergy;
import app.model.TimerVitality;
import app.util.SoundManager;
import app.model.TimerHungriness;
import app.model.TimerPortions;

import app.view.GameView;
import app.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JOptionPane;

import app.exceptions.*;

public class GameController implements ActionListener {
    
    private Familiar currentFamiliar;
    private Room currentRoom;
    private GameView gameView;
    private MainFrame  mainFrame;
    private SaveManager saveManager;
    private MenuController menuController; // to go back to MainMenu
    
    private TimerEnergy timerEnergy;
    private TimerVitality timerVitality;
    private TimerHungriness timerHungriness;
    private TimerPortions timerPortions;

    /**
     * Constructor
     * @param selectedFamiliar
     * @param mainFrame
     * @param menuController
     */
    public GameController(Familiar selectedFamiliar, MainFrame mainFrame, MenuController menuController) {
        currentFamiliar = selectedFamiliar;
        currentRoom = new Room(Rooms.LIVING_ROOM);
        this.mainFrame = mainFrame;
        flush();
        this.gameView = new GameView(mainFrame, this);
        this.saveManager = new SaveManager();
        this.menuController = menuController;
        
        timerEnergy = new TimerEnergy(currentFamiliar, gameView);
        timerEnergy.run();
        
        timerVitality = new TimerVitality(currentFamiliar, gameView, this.menuController);
        timerVitality.run();
        
        timerHungriness = new TimerHungriness(currentFamiliar, gameView, this.menuController);
        timerHungriness.run();
        
        timerPortions = new TimerPortions(currentFamiliar);
        timerPortions.run();
    }

    /**
     * @return currentFamiliar
     */
    public Familiar getFamiliar() {
        return this.currentFamiliar;
    }

    /**
     * @return currentRoom
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /** 
	 * Empties the mainFrame of all its components
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
    	if (e.getSource() == this.gameView.getSave()) { 
    		SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
            this.onClickSave();
    	}
    	else if(e.getSource() == this.gameView.getFeedButton()) {
    		SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
    		onClickFeed();
    	}
    	else if(e.getSource() == this.gameView.getWashButton()) {
    		SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
    		onClickWash();
    	}
    	else if(e.getSource() == this.gameView.getSleepButton()) {
    		SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
			onClickSleep();
    	}
    	else if(e.getSource() == this.gameView.getGoLeftButton()) {
    		SoundManager.playsound(SoundManager.SOUNDS_DOOR);
    		onClickGoLeft();
    	}
    	else if(e.getSource() == this.gameView.getGoRightButton()) {
    		SoundManager.playsound(SoundManager.SOUNDS_DOOR);
    		onClickGoRight();
    	}
	}
    
    /**
     * Method to create a backup when a button is clicked
     */ 
    private void onClickSave() {
        try {
            saveManager.writeSave(currentFamiliar);
    		SoundManager.playsound(SoundManager.SOUNDS_SAVE);
    		
    		/** 
    	     * displays a message to say that the backup was successful
    	     */
    		String saveSuccessMsg = "Votre progression a bien été sauvegardée !";
    		String[] saveSuccessOptions = {"Retour au menu", "Retour au jeu"};
    		int saveSuccessAnswer = JOptionPane.showOptionDialog(null, saveSuccessMsg, "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, saveSuccessOptions, saveSuccessOptions[1]);
    		
    		switch(saveSuccessAnswer){
    			case 0: // retour au menu
					SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
					menuController.mainMenuDisplay();
    				break;
    				
	    		case 1: // retour au jeu
					SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
	    			break;
    		
    			default:
					SoundManager.playsound(SoundManager.SOUNDS_MENU_CLICK);
    				menuController.mainMenuDisplay();
    		}
        } catch (IOException e) {
            e.printStackTrace();
            gameView.errorSave(e.toString());
        }
    }
    
    /**
     * Action taken when FeedButton is clicked
     */
    private void onClickFeed() {
        try {
            currentFamiliar.feed();
            gameView.getPbHunger().setValue(currentFamiliar.getHungriness());
            gameView.getFeedButton().setToolTipText(currentFamiliar.getPortions() + " portions de " + currentFamiliar.getFood() + " restantes");
            
        	switch(currentFamiliar.getFamiliarType()) {
        		case "Chat":
        			SoundManager.playsound(SoundManager.SOUNDS_EAT_FOOD,15f);
        			break;
        		
        		case "Chien":
        			SoundManager.playsound(SoundManager.SOUNDS_EAT_FOOD,15f);
        			break;
        			
        		case "Robot":
        			SoundManager.playsound(SoundManager.SOUNDS_EAT_CHARGE,15f);
        			break;
        			
        		case "Rabbit":
        			SoundManager.playsound(SoundManager.SOUNDS_EAT_FOOD,15f);
        			break;
        	}
            gameView.getMiddlePanel().changeRoom(currentRoom);
        }
        catch (FeedException e) {
            gameView.errorFeed(e.getMessage());
        }
    }

    /**
     * Action taken when WashButton is clicked
     */
    private void onClickWash() {
    	try {
    		currentFamiliar.wash();
            gameView.getPbhygiene().setValue(currentFamiliar.getHygiene());
    	}
    	catch (WashException e) {
    		gameView.errorWash(e.getMessage());
    	}
    }

    /**
     * Action taken when SleepButton is clicked
     */
    private void onClickSleep() {
		try {
			currentFamiliar.sleep();
			gameView.disableAll();
			// display
	        gameView.getMiddlePanel().sleep(currentRoom);
	        TimerSleep timerSleep = null;
	        if(currentFamiliar.getName().equals("Notch") && currentFamiliar.getFamiliarType().equals("Chien")) {
				timerSleep = new TimerSleep(currentFamiliar, gameView, 1000);
			}else {
				timerSleep = new TimerSleep(currentFamiliar, gameView);
			}
			timerSleep.run();
	    	timerEnergy.timerSleepUp();
	    	
		} catch (SleepException e) {
			gameView.errorSleep(e.getMessage());
		}	
    }

    /**
     * Action taken when GoLeftButton is clicked
     */
    private void onClickGoLeft() {
    	currentFamiliar.moveLeft();
        updateRoom();
        updateWeather();
        updateMood();
        gameView.getMiddlePanel().changeRoom(currentRoom);
        if (currentFamiliar.isDead()) isDeadByHygiene();
    }

    /**
     * Action taken when GoRightButton is clicked
     */
    private void onClickGoRight() {
    	currentFamiliar.moveRight();
        updateRoom();
        updateWeather();
        updateMood();
        gameView.getMiddlePanel().changeRoom(currentRoom);
        if (currentFamiliar.isDead()) isDeadByHygiene();
    }

    /**
     * Update the familiar's mood
     */
    private void updateMood() {
        if(currentFamiliar.getHygiene()%3 == 1) {
            currentFamiliar.decreaseMood();
            gameView.getMoodLabel().setText("Humeur : " + currentFamiliar.getMood().getName());
        }
    }

    /**
     * Change the weather
     */
    private void updateWeather() {
        if(getCurrentRoom().changeWeather()) {
            gameView.getCurrentWeatherLabel().setText("Météo : " + currentRoom.getWeatherName());
            gameView.getPbhygiene().setValue(currentFamiliar.getHygiene());
        }
    }

    /**
     * Update the room's state
     */
    private void updateRoom() {
        this.currentRoom = currentFamiliar.getRoom();
        currentFamiliar.changeMood();
        gameView.getCurrentRoomLabel().setText("Pièce : " + currentFamiliar.getRoom().getName());
    	gameView.getPbhygiene().setValue(currentFamiliar.getHygiene());
    }
    
    /**
     * Death by lack of hygiene
     */
    private void isDeadByHygiene() {
    	try {
    		saveManager.writeSave(currentFamiliar);
    	} catch (IOException e) {
    		e.printStackTrace();
    		gameView.errorSave(e.toString());
    	}
		String[] confirmOptions = {"Menu Principal", "Quitter"};
		int confirmAnswer = JOptionPane.showOptionDialog(null, currentFamiliar.getName()+" est mort d'insalubrité !", "Game Over !", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmOptions, confirmOptions[0]);
		if (confirmAnswer == 0) menuController.mainMenuDisplay();
		else System.exit(0);
    }
}