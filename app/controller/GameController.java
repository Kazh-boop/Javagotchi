package app.controller;

import javax.swing.JButton;
import app.*;

private Familiar familiar = new Familiar();
//private GamePanel gamePanel;

public class GameController {
    /*void GameController()
    
    public int onClickEatButton()
    {
        int result = this.familiar.getHungriness() + 35;
        this.familiar.setHungriness(result);
        return result;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }*/

    public int onClickHygieneButton(){
        if ((familiar.Rooms == GARDEN ) || (familiar.Rooms == KITCHEN)){
            int result = this.familiar.getHygiene()+ 35;
            this.familiar.setHygiene(result);
            return result;}


    }

   

    public int onClickSleepButton(){
        if (familiar.Rooms == LIVING_ROOM){
            forcedSleep();
            int result = this.familiar.getEnergy() + 35; 
            this.familiar.setEnergy(result);
            return result;}
    }

    public void forcedSleep(){
        if (energy<5){
            stopButton(7200000);}
        else{
            stopButton(6000);}
        }
    }

    public void stopButton(int delay){
        TimerForcedSleep timerForcedSleep = new TimerForcedSleep(familiar,delay,this);
        timerForcedSleep.run();
        hygieneButton.setEnabled(false);
        eatButton.setEnabled(false);
        sleepButton.setEnabled(false);
        // désactiver également les boutons de déplacements !
        
    }
        
}
