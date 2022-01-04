package app.controller;

import app.model.Familiar;
import app.model.Room;
import app.model.Rooms;
import app.model.SaveManager;

import app.model.TimerSleep;
import app.model.TimerEnergy;
import app.model.TimerVitality;
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

    // constructor
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

    // return the familiar
    public Familiar getFamiliar() {
        return this.currentFamiliar;
    }

    //return the room you are in
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /** 
	 * empties the mainFrame of all its components
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == this.gameView.getSave()) { 
    		menuController.playsound(menuController.getClickSound());
            this.onClickSave();
    	}
    	else if(e.getSource() == this.gameView.getFeedButton()) {
    		menuController.playsound(menuController.getClickSound());
    		onClickFeed();
    	}
    	else if(e.getSource() == this.gameView.getWashButton()) {
    		menuController.playsound(menuController.getClickSound());
    		onClickWash();
    	}
    	else if(e.getSource() == this.gameView.getSleepButton()) {
    		menuController.playsound(menuController.getClickSound());
			onClickSleep();
    	}
    	else if(e.getSource() == this.gameView.getGoLeftButton()) {
    		menuController.playsound(menuController.getDoorSound());
    		onClickGoLeft();
    	}
    	else if(e.getSource() == this.gameView.getGoRightButton()) {
    		menuController.playsound(menuController.getDoorSound());
    		onClickGoRight();
    	}
	}
    
    /**
     * method to create a backup when a button is clicked
     */ 
    private void onClickSave() {
        try {
            saveManager.writeSave(currentFamiliar);
    		menuController.playsound(menuController.getSaveSound());
            gameView.successfulSave();
        } catch (IOException e) {
            e.printStackTrace();
            gameView.errorSave(e.toString());
        }
    }
    
    /**
    * action taken when FeedButton is clicked
    */

    private void onClickFeed() {
        try {
            currentFamiliar.feed();
            gameView.getPbHunger().setValue(currentFamiliar.getHungriness());
            gameView.getFeedButton().setToolTipText(currentFamiliar.getPortions() + " portions de " + currentFamiliar.getFood() + " restantes ");
            gameView.getMiddlePanel().changeRoom(currentRoom);

        }
        catch (FeedException e) {
            gameView.errorFeed(e.getMessage());
        }
    }

    /**
    * action taken when WashButton is clicked
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
    * action taken when SleepButton is clicked
    */
    
    private void onClickSleep() {
    	try {
			currentFamiliar.sleep();
			gameView.disableAll();
			// display
	        gameView.getMiddlePanel().sleep(currentRoom);
			
			TimerSleep timerSleep = new TimerSleep(currentFamiliar, gameView);
	    	timerSleep.run();
	    	timerEnergy.timerSleepUp();
	    	// display out
	        gameView.getMiddlePanel().wakeup(currentRoom);
	    	
		} catch (SleepException e) {
			gameView.errorSleep(e.getMessage());
		}	
    }

    /**
    * action taken when GoLeftButton is clicked
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
    * action taken when GoRightButton is clicked
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
     * update the familiar's mood
     */

    private void updateMood() {
        if(currentFamiliar.getHygiene()%3 == 1) {
            currentFamiliar.decreaseMood();
            gameView.getMoodLabel().setText("Humeur : " + currentFamiliar.getMood().getName());
        }
    }

    /**
    * change the weather
    */
    
    private void updateWeather() {
        if(getCurrentRoom().changeWeather()) {
            gameView.getCurrentWeatherLabel().setText("Météo : " + currentRoom.getWeatherName());
            gameView.getPbhygiene().setValue(currentFamiliar.getHygiene());
        }
    }

    /**
    * change room
    */

    private void updateRoom() {
        this.currentRoom = currentFamiliar.getRoom();
        currentFamiliar.changeMood();
        gameView.getCurrentRoomLabel().setText("Pièce : " + currentFamiliar.getRoom().getName());
    	gameView.getPbhygiene().setValue(currentFamiliar.getHygiene());
    }
    
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