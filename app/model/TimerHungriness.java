package app.model;
			
import java.util.Timer;
import java.util.TimerTask;

import app.view.GameView;

public class TimerHungriness extends TimerTask {
    private Familiar familiar;
    private int minutesPerHungriness;
    private GameView gameView;

    // By default lose 1% every 10 minutes
    public TimerHungriness (Familiar familiar,GameView gameView){
        this.familiar = familiar;
        this.gameView = gameView;
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
                gameView.getPbHunger().setValue(familiar.getHungriness());
            }
          }, 0, minutesPerHungriness ); 
    }
}
