package app.model;
import java.util.Timer;
import java.util.TimerTask;

public class TimerEnergy extends TimerTask{
    private Familiar familiar;
    private int delay;
    private GameController gameController;

    public TimerEnergy(Familiar familiar,int delay,GameController gameController){
        this.familiar=familiar;
        this.delay=delay;
        this.gameController=gameController;

    }
    @Override
    public void run(){
        Timer timer;
        timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                familiar.setEnergy(100);
                hygieneButton.setEnabled(true);
                eatButton.setEnabled(true);
                sleepButton.setEnabled(true);
                timer.cancel();
                timer.purge();
               
                
            }
        },0,delay);
    }
    }
