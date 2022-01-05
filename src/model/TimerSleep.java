package model;

import java.util.Timer;
import java.util.TimerTask;

import view.GameView;

public class TimerSleep extends TimerTask{

    private Familiar familiar;
    private int minutesPerEnergy;
    private GameView gameView;
    private int count = 0;
    private int sleepProgress = 0;


	/**
	 * Constructor
	 * @param familiar
	 * @param gameView
	 */
    public TimerSleep(Familiar familiar, GameView gameView){
        this.familiar = familiar;
        minutesPerEnergy = 2 * 60 * 1000;
        this.gameView = gameView;
    }
    
    /**
     * Constructor with variable period
     * @param familiar
     * @param gameView
     * @param period
     */
    public TimerSleep(Familiar familiar,GameView gameView, int period){
        this.familiar = familiar;
        minutesPerEnergy = period;
        this.gameView = gameView;
    }
    
    /**
     * Starting the timer and changing setEnergy and setMoodValue
     * Update the progressBar "Sommeil", every 2 minutes
     */
    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	count++;
            	if (count <= 5) {
            		familiar.setEnergy(familiar.getEnergy() + 7);
                    familiar.setMoodValue(familiar.getMoodValue() + 2);
                    if (gameView != null) {
                        gameView.getPbEnergy().setValue(familiar.getEnergy());
                        gameView.getMoodLabel().setText("Humeur : " + familiar.getMood().getName());
                    }
                    
                    if(sleepProgress==0) {
	                    sleepProgress+=20;
                    }else {
                    	gameView.getMiddlePanel().getSleepProgressBar().setValue(sleepProgress);
                    	gameView.getMiddlePanel().getSleepProgressBar().setValue(sleepProgress);
	                    sleepProgress+=20;
                    }
                    
            	} else {
            		gameView.enableAll();
        	    	// display out
        	        gameView.getMiddlePanel().wakeup(familiar.getRoom());
                    timer.cancel();
                    timer.purge();
            		}
            }
        }, 0, minutesPerEnergy); //no waiting between actions, 1 action every x minutes
    }
}
