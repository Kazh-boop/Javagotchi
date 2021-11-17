package app.controller;

import javax.swing.JButton;
import app.model.Familiar;

private Familiar familiar = new Familiar();
private GamePanel gamePanel;

public class GameController {
    public int onClickEatButton()
    {
        int result = this.familiar.getHungriness() + 35;
        this.familiar.setHungriness(result);
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
