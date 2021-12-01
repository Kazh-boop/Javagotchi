package app.controller;

import app.model.Familiar;
import app.model.Room;
import app.model.Rooms;

public class GameController {
    
    Familiar currentFamiliar;
    Room currentRoom;

    public GameController(Familiar selectedFamiliar) {
        currentFamiliar = selectedFamiliar;
        currentRoom = new Room(Rooms.LIVING_ROOM);
    }

    public float calculateDecreaseValueHungriness() {
        return Math.abs(currentFamiliar.getHungriness() - (1*currentRoom.getWeatherCoef()*currentFamiliar.getMoodCoef());
    }

}
