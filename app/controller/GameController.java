package app.controller;

import app.model.Familiar;
import app.model.Room;
import app.model.Rooms;
import app.model.SaveManager;
import app.view.GameView;
import app.view.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameController implements ActionListener {
    
    Familiar currentFamiliar;
    Room currentRoom;
    GameView gameView;
    MainFrame  mainFrame;
    SaveManager saveManager;

    public GameController(Familiar selectedFamiliar, MainFrame mainFrame) {
        currentFamiliar = selectedFamiliar;
        currentRoom = new Room(Rooms.LIVING_ROOM);
        this.mainFrame = mainFrame;
        flush();
        this.gameView = new GameView(mainFrame, this);
        this.saveManager = new SaveManager();
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

    @Override
	public void actionPerformed(ActionEvent e) {
		
    	if (e.getSource().equals(this.gameView.getSave())) { // retour menu principal
    		this.onClickSave();
    	}
	}

    private void onClickSave() {

        try {
            saveManager.writeSave(currentFamiliar);
            gameView.successfulSave();
        } catch (IOException e) {
            e.printStackTrace();
            gameView.errorSave(e.toString());
        }
    }
}
