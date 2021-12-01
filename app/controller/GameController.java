package app.controller;

import javax.swing.JButton;
import app.*;

//private Familiar familiar = new Familiar();
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
            int result = this.familiar.getEnergy() + 35; //mais il ne peut plus bouger pendant 10 minutes
            this.familiar.setEnergy(result);
            return result;}
    }
        
}
