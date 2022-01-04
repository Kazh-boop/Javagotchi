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
import app.exceptions.*;

public class GameController implements ActionListener {
    
    Familiar currentFamiliar;
    Room currentRoom;
    GameView gameView;
    MainFrame  mainFrame;
    SaveManager saveManager;
    
    TimerEnergy timerEnergy;
    TimerVitality timerVitality;
    TimerHungriness timerHungriness;
    TimerPortions timerPortions;

    // constructor
    public GameController(Familiar selectedFamiliar, MainFrame mainFrame) {
        currentFamiliar = selectedFamiliar;
        currentRoom = new Room(Rooms.LIVING_ROOM);
        this.mainFrame = mainFrame;
        flush();
        this.gameView = new GameView(mainFrame, this);
        this.saveManager = new SaveManager();
        
        timerEnergy = new TimerEnergy(currentFamiliar, gameView);
        timerEnergy.run();
        
        timerVitality = new TimerVitality(currentFamiliar, gameView);
        timerVitality.run();
        
        timerHungriness = new TimerHungriness(currentFamiliar, gameView);
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
            this.onClickSave();
    	}
    	else if(e.getSource() == this.gameView.getFeedButton()) {
    		onClickFeed();
    	}
    	else if(e.getSource() == this.gameView.getWashButton()) {
    		onClickWash();
    	}
    	else if(e.getSource() == this.gameView.getSleepButton()) {
			onClickSleep();
    	}
    	else if(e.getSource() == this.gameView.getGoLeftButton()) {
    		onClickGoLeft();
    	}
    	else if(e.getSource() == this.gameView.getGoRightButton()) {
    		onClickGoRight();
    	}
	}
    
    /**
     * method to create a backup when a button is clicked
     */ 
    private void onClickSave() {
        try {
            saveManager.writeSave(currentFamiliar);
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
			TimerSleep timerSleep = new TimerSleep(currentFamiliar, gameView);
	    	timerSleep.run();
	    	timerEnergy.timerSleepUp();
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
    }

    /**
    * action taken when GoRightButton is clicked
    */

    private void onClickGoRight() {
    	currentFamiliar.moveRight();
        updateRoom();
        updateWeather();
        updateMood();
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
        currentFamiliar.changeMood();
        gameView.getCurrentRoomLabel().setText("Pièce : " + currentFamiliar.getRoom().getName());
    	gameView.getPbhygiene().setValue(currentFamiliar.getHygiene());
    }
}
