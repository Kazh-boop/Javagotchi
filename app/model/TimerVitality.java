package app.model;

import java.util.Timer;
import java.util.TimerTask;

import app.view.GameView;

public class TimerVitality extends TimerTask {
    private Familiar familiar;
    private int minutesPerVitality;
    private GameView gameView;


    public TimerVitality(Familiar familiar, GameView gameView){
        this.familiar = familiar;
        this.gameView = gameView;
        minutesPerVitality = 6 * 60 * 1000;
    }
    
    public TimerVitality(Familiar familiar, GameView gameView, int period){
        this.familiar = familiar;
        this.gameView = gameView;
        minutesPerVitality = period;
    }
    
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
                
            }
          }, 0, minutesPerVitality); //wait 0 ms before doing the action and do it every 30 minutes
    }
}
