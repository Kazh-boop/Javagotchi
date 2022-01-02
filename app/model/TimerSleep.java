package app.model;

import java.util.Timer;
import java.util.TimerTask;

import app.view.GameView;

public class TimerSleep extends TimerTask{

    private Familiar familiar;
    private int minutesPerEnergy;
    private GameView gameView;
    private int count = 0;
	
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
            	}
            	else {
            		gameView.enableAll();
                    timer.cancel();
                    timer.purge();
            	}
            }
          }, 0, minutesPerEnergy); //no waiting between actions, 1 action every x minutes
    }
}
