package app.model;
			
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class TimerPortions extends TimerTask implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Familiar familiar;
    private static final int MINUTES_PER_PORTION = 30 * 60 * 1000;
    
    // attributs tests
    private final long period;


    public TimerPortions(Familiar familiar){
        this.familiar = familiar;
        this.period = MINUTES_PER_PORTION;
    }
    
    /**
     * Constructeur test
     */
    public TimerPortions(Familiar familiar, long period) {
        this.familiar = familiar;
        this.period = period;
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
          }, 0, MINUTES_PER_PORTION); //wait 0 ms before doing the action and do it evry 30 minutes
    }
    
    /**
     * utilisee pour les tests pour avoir un controle sur le temps
     */
    public void start() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(familiar.getPortions());
                familiar.addPortion();
            }
          }, 0, this.period); //wait 0 ms before doing the action and do it evry 30 minutes
    }
}
