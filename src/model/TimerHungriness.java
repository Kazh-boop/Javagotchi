package model;
			
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import controller.MenuController;
import view.GameView;

public class TimerHungriness extends TimerTask {
    private Familiar familiar;
    private int minutesPerHungriness;
    private GameView gameView;
    private MenuController menuController;

    /**
     * Constructor
     * By default lose 1% every 10 minutes
     * @param familiar
     * @param gameView
     * @param menuController
     */
    public TimerHungriness (Familiar familiar,GameView gameView, MenuController menuController){
        this.familiar = familiar;
        this.gameView = gameView;
        this.menuController = menuController;
        minutesPerHungriness = 10 * 60 * 1000;
    }
    
    /**
     * Constructor with variable period
     * @param familiar
     * @param gameView
     * @param menuController
     * @param period
     */
    public TimerHungriness (Familiar familiar, GameView gameView, MenuController menuController, int period){
        this.familiar = familiar;
        this.gameView = gameView;
        this.menuController = menuController;
        minutesPerHungriness = period;
    }
    
    /**
     * Start the timer and change the value of setHungriness as the familiar rests
     */
    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                familiar.setHungriness(familiar.getHungriness() - 1);
               
                if (gameView != null) {
                    if(familiar.getHungriness()%3 == 1) {
                        familiar.decreaseMood();
                        gameView.getMoodLabel().setText("Humeur : " + familiar.getMood().getName());
                    }
                	gameView.getPbHunger().setValue(familiar.getHungriness());
                }
                
                if (familiar.isDead()) {
                	timer.cancel();
                	try {
                		new SaveManager().writeSave(familiar);
                	} catch (IOException e) {
                		e.printStackTrace();
                		gameView.errorSave(e.toString());
                	}
            		String[] confirmOptions = {"Menu Principal", "Quitter"};
            		int confirmAnswer = JOptionPane.showOptionDialog(null, familiar.getName()+" est mort de faim !", "Game Over !", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmOptions, confirmOptions[0]);
            		if (confirmAnswer == 0) menuController.mainMenuDisplay();
            		else System.exit(0);
                }
            }
          }, 0, minutesPerHungriness ); 
    }
}