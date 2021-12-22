package app.model;

import java.util.Timer;
import java.util.TimerTask;

public class TimerVitality extends TimerTask {
    private Familiar familiar;
    private static int MINUTES_PER_ENERGY;


    public TimerVitality(Familiar familiar){
        this.familiar = familiar;
        MINUTES_PER_ENERGY = 60 * 60 * 1000;
    }
    
    public TimerVitality(Familiar familiar, int period){
        this.familiar = familiar;
        MINUTES_PER_ENERGY = period;
    }
    
    Boolean increased()
    {
    	Boolean result = false;
    	if	(
    		familiar.getEnergy() > 90 &&
    		familiar.getHygiene() > 90 &&
    		familiar.getHappiness() > 90 &&
    		familiar.getHungriness() > 90
    		)
    	{
    		result = true;
    	}
    	return result;
    }
    
    Boolean decreased()
    {
    	Boolean result = false;
    	if	(
    		familiar.getEnergy() < 15 &&
    		familiar.getHygiene() < 15 &&
    		familiar.getHappiness() < 15 &&
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
                if(increased())
                {
                	familiar.setEnergy(familiar.getEnergy() + 10);
                }
                else if(decreased())
                {
                	familiar.setEnergy(familiar.getEnergy() - 5);
                }
                
            }
          }, 0, MINUTES_PER_ENERGY); //wait 0 ms before doing the action and do it every 30 minutes
    }
}
