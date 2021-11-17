package app.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.controller.NouvellePartieMenuController;

public class NouvellePartieMenu {
	
	NouvellePartieMenuController menuController;
	MainFrame mainFrame;
	JPanel mainPanel;
	
	JLabel Titre;

    public NouvellePartieMenu() {
    	
        this.menuController = new NouvellePartieMenuController(this);
        this.mainFrame = new MainFrame();
        this.mainPanel = new JPanel();
        
        // composition des JComponent
        this.Titre = new JLabel("Nouvelle Partie");
        
        // placement des JComponent
        
        // habillage des JComponent 
        
        // création des eventListener pour les JButton
        
        // ajout des éléments dans la mainFrame
        mainPanel.add(Titre);
        mainFrame.add(mainPanel);
        
        
        // habillage de la mainFrame
        mainPanel.setLayout(new GridLayout(4,1,0,50));
        mainFrame.setSize(1280,720);
        mainFrame.setVisible(true); //if false then frame will be invisible
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
}
