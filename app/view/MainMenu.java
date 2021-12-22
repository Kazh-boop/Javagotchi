package app.view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
        Color cactusGreen = new Color(104, 131, 53);
        Color pearl = new Color(245, 235, 218);
        newGame.setForeground(cactusGreen);
        newGame.setBackground(pearl);
        saves.setForeground(cactusGreen);
        saves.setBackground(pearl);
        quit.setForeground(Color.red);
        quit.setBackground(pearl);
        
        // creation des eventListener pour les JButton
        this.newGame.addActionListener(this.mainController);
        this.saves.addActionListener(this.mainController);
        this.quit.addActionListener(this.mainController);
        
        // ajout des elements dans la mainFrame
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
   
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(title);
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(newGame);
        saves.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(saves);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(quit);
        mainPanel.add(Box.createVerticalGlue());
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