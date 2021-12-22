package app.controller;

import app.model.Familiar;
import app.model.Room;
import app.model.Rooms;
import app.view.GameView;
import app.view.MainFrame;

public class GameController {
    
    Familiar currentFamiliar;
    Room currentRoom;
    GameView gameView;
    MainFrame  mainFrame;

    public GameController(Familiar selectedFamiliar, MainFrame mainFrame) {
        currentFamiliar = selectedFamiliar;
        currentRoom = new Room(Rooms.LIVING_ROOM);
        this.mainFrame = mainFrame;
        flush();
        this.gameView = new GameView(mainFrame, this);

    }

    public float calculateDecreaseValue(float currentValue) {
        return Math.abs(currentValue - (1*currentRoom.getWeatherCoef()*currentFamiliar.getMoodCoef()));
    }

    public Familiar getFamiliar() {
        return this.currentFamiliar;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /** 
	 * Vide la mainFrame de tous ses composants
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}
}
