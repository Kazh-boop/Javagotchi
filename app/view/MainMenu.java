package app.view;

import javax.swing.*;
import java.awt.GridLayout;

import app.controller.*;

public class MainMenu {
	
	MenuController mainController;
	MainFrame mainFrame;
	JPanel mainPanel;
	
	JLabel title;
    JButton newGame;
    JButton saves;
    JButton quit;

    public MainMenu(){}
    
    public void display(MenuController nController, MainFrame nFrame) {
    	this.mainController = nController;
        this.mainFrame = nFrame;
        
        this.mainPanel = new JPanel();
        
        // composition des JComponent
        this.title = new JLabel("Titre");
        this.newGame = new JButton("Nouvelle Partie");
        this.saves = new JButton("Sauvegardes");
        this.quit = new JButton("Quitter");
        
        // placement des JComponent
        
        // habillage des JComponent 
        //newGame.setPreferredSize(new Dimension(150,100));
        //saves.setPreferredSize(new Dimension(150,100));
        //quit.setPreferredSize(new Dimension(150,100));
        
        // creation des eventListener pour les JButton
        this.newGame.addActionListener(this.mainController);
        this.saves.addActionListener(this.mainController);
        this.quit.addActionListener(this.mainController);
        
        // ajout des elements dans la mainFrame
        mainPanel.setLayout(new GridLayout(4,1,0,50));
        mainPanel.add(title);
        mainPanel.add(newGame);
        mainPanel.add(saves);
        mainPanel.add(quit);
        mainFrame.add(mainPanel);
        
        mainFrame.setVisible(true);
    }
    
    public JButton getNewGame(){
        return newGame;
    }
    
    public JButton getSaves(){
        return saves;
    }
    
    public JButton getQuit(){
        return quit;
    }
    
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
}