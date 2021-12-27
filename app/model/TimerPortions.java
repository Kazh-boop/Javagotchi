package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

public class TimerPortions extends TimerTask {
    private Familiar familiar;
    private int minutesPerPortion;

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
                System.out.println(familiar.getPortions());
                familiar.addPortion();
            }
          }, 0, minutesPerPortion); //aucune attente entre chaque actions, 1 actions toutes les x minutes
    }
   
}
