package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

public class TimerPortions extends TimerTask {
    private Familiar familiar;
    private static int MINUTES_PER_PORTION;

    public TimerPortions(Familiar familiar){
        this.familiar = familiar;
        MINUTES_PER_PORTION = 30 * 60 * 1000;
    }
    
    public TimerPortions(Familiar familiar, int period){
        this.familiar = familiar;
        MINUTES_PER_PORTION = period;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(familiar.getPortions());
                familiar.addPortion();
            }
          }, 0, MINUTES_PER_PORTION); //aucune attente entre chaque actions, 1 actions toutes les x minutes
    }
   
}
