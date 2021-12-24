package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

public class TimerEnergy extends TimerTask {
    private Familiar familiar;
    private static int MINUTES_PER_PORTION;

    public TimerEnergy(Familiar familiar){
        this.familiar = familiar;
        MINUTES_PER_PORTION =  10 * 60 * 1000;
    }
    
    public TimerEnergy(Familiar familiar, int period){
        this.familiar = familiar;
        MINUTES_PER_PORTION = period;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                familiar.setEnergy(familiar.getEnergy()-1);
            }
          }, 0, MINUTES_PER_PORTION); 
    }
}
