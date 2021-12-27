package app.model;

import java.util.Timer;
import java.util.TimerTask;

public class TimerVitality extends TimerTask {
    private Familiar familiar;
    private static int MINUTES_PER_VITALITY;


    public TimerVitality(Familiar familiar){
        this.familiar = familiar;
        MINUTES_PER_VITALITY = 6 * 60 * 1000;
    }
    
    public TimerVitality(Familiar familiar, int period){
        this.familiar = familiar;
        MINUTES_PER_VITALITY = period;
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
                	System.out.println("Energie UP");
                	familiar.setVitality(familiar.getVitality() + 1);
                }
                if(decreased())
                {
                	System.out.println("Energie DOWN");
                	familiar.setVitality(familiar.getVitality() - 1);
                }
                
            }
          }, 0, MINUTES_PER_VITALITY); //wait 0 ms before doing the action and do it every 30 minutes
    }
}
