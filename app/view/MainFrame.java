package app.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    
    public MainFrame() {
        super();
        
        // Creer une MainFrame de taille fixe 1280x720
        Dimension frame = new Dimension(1280, 720);
        setPreferredSize(frame);
        setSize(frame);
        setResizable(false);
        
        // Centre la fenetre
        Dimension userScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((userScreenSize.getWidth()-1280) / 2);
        int y = (int) ((userScreenSize.getHeight()-720) / 2);
        setBounds(x, y, 0, 0);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //ends program when JFrame closed
        setTitle("Tamagotchi");
        
        pack();
    }
}