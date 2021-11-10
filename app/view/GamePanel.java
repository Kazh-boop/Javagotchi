package app.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GamePanel {
    private MainFrame mainFrame = new MainFrame();
    private JButton eatButton = new JButton("Nourrir");

    public void init()
    {
        this.mainFrame.add(eatButton);
    }

    public void gamePanel(MainFrame mainFrame) { 
        eatButton.addActionListener(new ActionListener())
        {
            
        }
    }


}
