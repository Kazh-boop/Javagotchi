package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

public class TimerEnergy extends TimerTask {
    private Familiar familiar;
    private static final int MINUTES_PER_PORTION = 10 *60 * 1000;

    public TimerEnergy(Familiar familiar){
        this.familiar = familiar;
    }

    @Override
    public void run() {
        Timer timer;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(familiar.getEnergy());
                familiar.setEnergy(familiar.getEnergy()-1);
            }
          }, 0, MINUTES_PER_PORTION); 
    }
}
