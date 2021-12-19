package app.model;
			
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class TimerEnergy extends TimerTask implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Familiar familiar;
    private static final int MINUTES_PER_PORTION = 10 *60 * 1000;
    
    // attributs tests
    private final long period;

    public TimerEnergy(Familiar familiar){
        this.familiar = familiar;
        this.period = MINUTES_PER_PORTION;
    }
    
    /**
     * Constructeur tests
     */
    public TimerEnergy(Familiar familiar, long period) {
    	this.familiar = familiar;
    	this.period = period;
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
    
    
    /**
     * utilisee pour les tests pour avoir un controle sur le temps
     */
    public void start() {
        Timer timer;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(familiar.getEnergy());
                familiar.setEnergy(familiar.getEnergy()-1);
            }
          }, 0, period); 
    }
}
