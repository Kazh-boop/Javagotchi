package app.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program when JFrame closed

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true); //if false then frame will be invisible
        setResizable(false);
    }
}