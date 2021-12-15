package app.controller;

import app.model.Familiar;
import app.model.Room;
import app.model.Rooms;
import app.view.GamePanel;
import app.model.*;

//private GamePanel gamePanel;
import javax.swing.JButton;
//import app.*;
import app.view.GameView;
import app.view.MainFrame;

public class GameController {
    
    Familiar currentFamiliar;
    Room currentRoom;
    GamePanel gamePanel;
    GameView gameView;

    public GameController(Familiar selectedFamiliar, MainFrame mainFrame) {
        currentFamiliar = selectedFamiliar;
        currentRoom = new Room(Rooms.LIVING_ROOM);
        this.gameView = new GameView(mainFrame);
    }

    public GameController(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public float calculateDecreaseValueHungriness() {
        return Math.abs(currentFamiliar.getHungriness() - (1*currentRoom.getWeatherCoef()*currentFamiliar.getMoodCoef()));
    }

    public int onClickHygieneButton(){
        if ((currentFamiliar.getRooms() == Rooms.GARDEN ) || (currentFamiliar.getRooms() == Rooms.KITCHEN)){
            currentFamiliar.setHygiene(this.currentFamiliar.getHygiene() + 35);
        }
        return currentFamiliar.getHygiene();
    }
    
    public float calculateDecreaseValue(float currentValue) {
        return Math.abs(currentValue - (1*currentRoom.getWeatherCoef()*currentFamiliar.getMoodCoef()));
    }

    public int onClickSleepButton(){
        if (currentFamiliar.getRooms() == Rooms.LIVING_ROOM){
            this.currentFamiliar.setEnergy(this.currentFamiliar.getEnergy() + 35); //mais il ne peut plus bouger pendant 10 minutes
        }
        return currentFamiliar.getHygiene();
    }

    public void forcedSleep(){
        if (currentFamiliar.getEnergy()<5){
            stopButton(7200000);
        }
    }

    public void stopButton(int delay){
        TimerForcedSleep timerForcedSleep = new TimerForcedSleep(currentFamiliar,delay,gamePanel);
        timerForcedSleep.run();
        gamePanel.getHygieneButton().setEnabled(false);
        gamePanel.getEaButton().setEnabled(false);
        gamePanel.getSleepButton().setEnabled(false);
        // désactiver également les boutons de déplacements !
        
    }
        
}
