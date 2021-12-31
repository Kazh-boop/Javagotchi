package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

public class TimerEnergy extends TimerTask {
	
    private Familiar familiar;
    private int minutesPerEnergy;


    /**
     * constructor
     * minutesPerEnergy is 10 minutes because this timer is used for the sleep action
     */
    public TimerEnergy(Familiar familiar){
        this.familiar = familiar;
        minutesPerEnergy = 10 * 60 * 1000;
    }
    
    public TimerEnergy(Familiar familiar, int period){
        this.familiar = familiar;
        minutesPerEnergy = period;
    }
    /**
     * start the timer and change the value of setEnergy as the familiar rests
     */
    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                familiar.setEnergy(familiar.getEnergy()-1);
            }
          }, 0, minutesPerEnergy); 
    }
}
