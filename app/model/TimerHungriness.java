package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

public class TimerHungriness extends TimerTask {
    private Familiar familiar;
    private int minutesPerHungriness;

    // By default lose 1% every 10 minutes
    public TimerHungriness (Familiar familiar){
        this.familiar = familiar;
        minutesPerHungriness = 10 * 60 * 1000;
    }
    
    public TimerHungriness (Familiar familiar, int period){
        this.familiar = familiar;
        minutesPerHungriness = period;
    }
    
    // Start the timer and change the value of setHungriness as the familiar rests
    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                familiar.setHungriness(familiar.getHungriness() - 1);
            }
          }, 0, minutesPerHungriness ); 
    }
}
