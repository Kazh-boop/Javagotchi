package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

import app.view.GameView;

public class TimerEnergy extends TimerTask {
	
    private Familiar familiar;
    private int minutesPerEnergy;
    private GameView gameView;
    private Boolean isTimerSleepUp = false;

    /**
     * Constructor
     * minutesPerEnergy is 10 minutes because this timer is used for the sleep action
     * @param familiar
     * @param gameView
     */
    public TimerEnergy(Familiar familiar, GameView gameView){
        this.familiar = familiar;
        minutesPerEnergy = 10 * 60 * 1000;
        this.gameView = gameView;
    }
    
    /**
     * Constructor with variable period
     * minutesPerEnergy is 10 minutes because this timer is used for the sleep action
     * @param familiar
     * @param gameView
     * @param period
     */
    public TimerEnergy(Familiar familiar,GameView gameView, int period){
        this.familiar = familiar;
        minutesPerEnergy = period;
        this.gameView = gameView;
    }
    
    /**
     * set isTimerSleepUp to true
     */
    public void timerSleepUp() {
    	isTimerSleepUp = true;
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
            	if(Boolean.FALSE.equals(isTimerSleepUp)) {
                    familiar.setEnergy(familiar.getEnergy()-1);
                    if (gameView != null) {
                        if(familiar.getEnergy()%3 == 1) {
                            familiar.decreaseMood();
                            gameView.getMoodLabel().setText("Humeur : " + familiar.getMood().getName());
                        }
                    	gameView.getPbEnergy().setValue(familiar.getEnergy());
                    }
                }
            	else {
            		isTimerSleepUp = false;
            	}

            }
          }, 0, minutesPerEnergy); 
    }
}
