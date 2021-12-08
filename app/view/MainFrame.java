package app.view;

import javax.swing.*;
import java.awt.Dimension;
public class MainFrame extends JFrame {
    
    public MainFrame() {
        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program when JFrame closed

        setPreferredSize(new Dimension(500, 500));
        pack();
    }
}