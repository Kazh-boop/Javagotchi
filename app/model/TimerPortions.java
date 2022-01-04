package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

public class TimerPortions extends TimerTask {
    private Familiar familiar;
    private int minutesPerPortion;


    /**
    * Constructor
    */
    public TimerPortions(Familiar familiar){
        this.familiar = familiar;
        minutesPerPortion = 30 * 60 * 1000;
    }
    
    public TimerPortions(Familiar familiar, int period){
        this.familiar = familiar;
        minutesPerPortion = period;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                familiar.addPortion();
            }
          }, 0, minutesPerPortion); //no waiting between actions, 1 action every x minutes
    }
   
}
