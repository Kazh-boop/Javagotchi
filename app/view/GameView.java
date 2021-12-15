package app.view;

import javax.swing.JFrame;
import java.awt.GridLayout;


public class GameView {
    
    private JFrame mainFrame;

    public GameView(JFrame nFrame){
        this.mainFrame = nFrame;
        display();
    }

    private void display(){
        mainFrame.setLayout(new GridLayout(0, 1));

    }
}
