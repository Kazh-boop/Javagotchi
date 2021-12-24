package app.model;
import java.util.Timer;
import java.util.TimerTask;

import app.view.GameView;

public class TimerForcedSleep extends TimerTask{
    private Familiar familiar;
    private int delay;
    private GameView gameView;

    public TimerForcedSleep(Familiar familiar,int delay,GameView gameView){
        this.familiar = familiar;
        this.delay = delay;
        this.gameView = gameView;

    }
    @Override
    public void run(){
        Timer timer;
        timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                familiar.setEnergy(100);
                /*gameView.getHygieneButton().setEnabled(true);
                gameView.getEaButton().setEnabled(true);
                gameView.getSleepButton().setEnabled(true);*/
                timer.cancel();
                timer.purge();
               
                
            }
        },0,delay);
    }
    }
