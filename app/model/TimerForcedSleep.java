package app.model;
import java.util.Timer;
import java.util.TimerTask;

import app.view.*;

public class TimerForcedSleep extends TimerTask{
    private Familiar familiar;
    private int delay;
    private GamePanel gamePanel;

    public TimerForcedSleep(Familiar familiar,int delay,GamePanel gamePanel){
        this.familiar=familiar;
        this.delay=delay;
        this.gamePanel = gamePanel;

    }
    @Override
    public void run(){
        Timer timer;
        timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                familiar.setEnergy(100);
                gamePanel.getHygieneButton().setEnabled(true);
                gamePanel.getEaButton().setEnabled(true);
                gamePanel.getSleepButton().setEnabled(true);
                timer.cancel();
                timer.purge();
               
                
            }
        },0,delay);
    }
    }
