package app.model;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import app.controller.MenuController;
import app.view.GameView;

public class TimerVitality extends TimerTask {
    private Familiar familiar;
    private int minutesPerVitality;
    private GameView gameView;
    private MenuController menuController;

    /**
     * Constructor
     * @param familiar
     * @param gameView
     * @param menuController
     */
    public TimerVitality(Familiar familiar, GameView gameView, MenuController menuController){
        this.familiar = familiar;
        this.gameView = gameView;
        this.menuController = menuController;
        minutesPerVitality = 6 * 60 * 1000;
    }
    
    /**
     * Constructor with variable period
     * @param familiar
     * @param gameView
     * @param menuController
     * @param period
     */
    public TimerVitality(Familiar familiar, GameView gameView, MenuController menuController,  int period){
        this.familiar = familiar;
        this.menuController = menuController;
        this.gameView = gameView;
        minutesPerVitality = period;
    }

    /**
     * returns true if vitality is above 90%
     * @return boolean
     */
    private Boolean increased()
    {
    	Boolean result = false;
    	if	(
    		familiar.getEnergy() > 90 &&
    		familiar.getHygiene() > 90 &&
    		familiar.getMood().equals(Mood.HAPPY) &&
    		familiar.getHungriness() > 90
    		)
    	{
    		result = true;
    	}
    	return result;
    }

    /**
    * returns true if vitality is below 15%
    * @return boolean
    */
    private Boolean decreased()
    {
    	Boolean result = false;
    	if	(
    		familiar.getEnergy() < 15 &&
    		familiar.getHygiene() < 15 &&
    		familiar.getMood().equals(Mood.MISERABLE) &&
    		familiar.getHungriness() < 15
    		)
    	{
    		result = true;
    	}
    	return result;
    }

    /**
     * starting the timer and changing setVitality
     */
    @Override
    public void run() {
        Timer timer = new Timer();
  
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(Boolean.TRUE.equals(increased()))
                {
                	System.out.println("Energie UP");
                	familiar.setVitality(familiar.getVitality() + 1);	
                }
                if(Boolean.TRUE.equals(decreased()))
                {
                	System.out.println("Energie DOWN");
                	familiar.setVitality(familiar.getVitality() - 1);
                }
                if (gameView != null)
                	gameView.getPbVitality().setValue(familiar.getVitality());
                
                if (familiar.isDead()) {
                	timer.cancel();
                	try {
                		new SaveManager().writeSave(familiar);
                	} catch (IOException e) {
                		e.printStackTrace();
                		gameView.errorSave(e.toString());
                	}
            		String[] confirmOptions = {"Menu Principal", "Quitter"};
            		int confirmAnswer = JOptionPane.showOptionDialog(null, familiar.getName()+" est mort par vitalité !", "Game Over !", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmOptions, confirmOptions[0]);
            		if (confirmAnswer == 0) menuController.mainMenuDisplay();
            		else System.exit(0);
                }
                
            }
          }, 0, minutesPerVitality); //wait 0 ms before doing the action and do it every 30 minutes
    }
}