package app.controller;

import app.model.Familiar;
import app.model.Room;
import app.model.Rooms;
import app.view.GamePanel;

import javax.swing.JButton;
import app.*;

public class GameController {
    
    Familiar currentFamiliar;
    Room currentRoom;
    GamePanel gamePanel;

    public GameController(Familiar selectedFamiliar) {
        currentFamiliar = selectedFamiliar;
        currentRoom = new Room(Rooms.LIVING_ROOM);
    }

    public GameController(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public float calculateDecreaseValueHungriness() {
        return Math.abs(currentFamiliar.getHungriness() - (1*currentRoom.getWeatherCoef()*currentFamiliar.getMoodCoef());
    }

    public int onClickHygieneButton(){
        if ((currentFamiliar.getRooms() == Rooms.GARDEN ) || (currentFamiliar.getRooms() == Rooms.KITCHEN)){
            currentFamiliar.setHygiene(this.currentFamiliar.getHygiene() + 35);
        }
        return currentFamiliar.getHygiene();
    }

    public int onClickSleepButton(){
        if (currentFamiliar.getRooms() == Rooms.LIVING_ROOM){
            this.currentFamiliar.setEnergy(this.currentFamiliar.getEnergy() + 35); //mais il ne peut plus bouger pendant 10 minutes
        }
        return currentFamiliar.getHygiene();
    }
        
}
