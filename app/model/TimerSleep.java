package app.model;

import java.util.Timer;
import java.util.TimerTask;

import app.view.GameView;

public class TimerSleep extends TimerTask{

    private Familiar familiar;
    private int minutesPerEnergy;
    private GameView gameView;
    private int count = 0;


	/**
     * constructor
     */

    public TimerSleep(Familiar familiar, GameView gameView){
        this.familiar = familiar;
        minutesPerEnergy = 2 * 60 * 1000;
        this.gameView = gameView;
    }
    
    public TimerSleep(Familiar familiar,GameView gameView, int period){
        this.familiar = familiar;
        minutesPerEnergy = period;
        this.gameView = gameView;
    }
    
    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	count++;
            	if (count <= 5)  
            	{
            		familiar.setEnergy(familiar.getEnergy() + 7);
                    familiar.setMoodValue(familiar.getMoodValue() + 2);
                    if (gameView != null) {
                        gameView.getPbEnergy().setValue(familiar.getEnergy());
                        gameView.getMoodLabel().setText("Humeur : " + familiar.getMood().getName());
                    }
            	}
            	else {
            		gameView.enableAll();
                    timer.cancel();
                    timer.purge();
            	}
            }
          }, minutesPerEnergy, 1); //no waiting between actions, 1 action every x minutes
    }
}
