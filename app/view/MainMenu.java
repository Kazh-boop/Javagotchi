package app.view;

import javax.swing.*;
import java.awt.GridLayout;

import app.controller.*;

public class MainMenu {
	
	MainMenuController mainMenuController;
	MainFrame mainFrame;
	JPanel mainPanel;
	
	JLabel Titre;
    JButton nouvellePartie;
    JButton sauvegardes;
    JButton quitter;

    public MainMenu() {
    	
        this.mainMenuController = new MainMenuController(this);
        this.mainFrame = new MainFrame();
        this.mainPanel = new JPanel();
        
        // composition des JComponent
        this.Titre = new JLabel("Titre");
        this.nouvellePartie = new JButton("Nouvelle Partie");
        this.sauvegardes = new JButton("Sauvegardes");
        this.quitter = new JButton("Quitter");
        
        // placement des JComponent
        
        // habillage des JComponent 
        //nouvellePartie.setPreferredSize(new Dimension(150,100));
        //sauvegardes.setPreferredSize(new Dimension(150,100));
        //quitter.setPreferredSize(new Dimension(150,100));
        
        // creation des eventListener pour les JButton
        this.nouvellePartie.addActionListener(this.mainMenuController);
        this.sauvegardes.addActionListener(this.mainMenuController);
        this.quitter.addActionListener(this.mainMenuController);
        
        // ajout des elements dans la mainFrame
        mainPanel.add(Titre);
        mainPanel.add(nouvellePartie);
        mainPanel.add(sauvegardes);
        mainPanel.add(quitter);
        mainFrame.add(mainPanel);
        
        
        // habillage de la mainFrame
        mainPanel.setLayout(new GridLayout(4,1,0,50));
        mainFrame.setSize(1280,720);
        mainFrame.setVisible(true); //if false then frame will be invisible
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getNouvellePartie(){
        return nouvellePartie;
    }
    
    public JButton getSauvegardes(){
        return sauvegardes;
    }
    
    public JButton getQuitter(){
        return quitter;
    }
    
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
}