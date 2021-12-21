package app.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;

import app.controller.*;

public class MainMenu {
	
	MenuController mainController;
	MainFrame mainFrame;
	JPanel mainPanel;
	
	CustomMenuLabel title;
    CustomMenuButton newGame;
    CustomMenuButton saves;
    CustomMenuButton quit;
    
    /**
     * Constructeur
     * @param nController MenuController
     */
    public MainMenu(MenuController nController){
    	this.mainController = nController;
    	this.mainFrame = mainController.getMainFrame();
    }
    
    /**
     * Affiche le menu principal
     * @param nController MenuController
     */
    public void display(MenuController nController) {
    	this.mainController = nController;
        
        this.mainPanel = new JPanel();
        
        // composition des JComponent
        this.title = new CustomMenuLabel("Tamagotchi", 96f, SwingConstants.CENTER);
        this.newGame = new CustomMenuButton("Nouvelle Partie");
        this.saves = new CustomMenuButton("Sauvegardes");
        this.quit = new CustomMenuButton("Quitter");
        
        // habillage personalise        
        Color cactus_green = new Color(104, 131, 53);
        Color pearl = new Color(245, 235, 218);
        newGame.setForeground(cactus_green);
        newGame.setBackground(pearl);
        saves.setForeground(cactus_green);
        saves.setBackground(pearl);
        quit.setForeground(Color.red);
        quit.setBackground(pearl);
        
        // creation des eventListener pour les JButton
        this.newGame.addActionListener(this.mainController);
        this.saves.addActionListener(this.mainController);
        this.quit.addActionListener(this.mainController);
        
        // ajout des elements dans la mainFrame
        mainPanel.setLayout(new GridLayout(4,1,50,50));
        mainPanel.add(title);
        mainPanel.add(newGame);
        mainPanel.add(saves);
        mainPanel.add(quit);
        mainFrame.add(mainPanel);
        
        mainFrame.setVisible(true);
    }
    
    /**
     * @return newGame JButton
     */
    public JButton getNewGame(){
        return newGame;
    }
    
    /**
     * @return saves JButton
     */
    public JButton getSaves(){
        return saves;
    }
    
    /**
     * @return quit JButton
     */
    public JButton getQuit(){
        return quit;
    }
    
    /**
     * @return mainFrame JFrame
     */
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
}