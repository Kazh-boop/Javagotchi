package app.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import app.controller.*;

public class MainMenu {
	
	MenuController mainController;
	MainFrame mainFrame;
	JPanel mainPanel;
	
	JLabel title;
    JButton newGame;
    JButton saves;
    JButton quit;
    
    /** MainMenu(MainFrame)
     * 
     * Constructeur de MainMenu
     * @param nFrame
     */
    public MainMenu(MainFrame nFrame){
    	this.mainFrame = nFrame;
    }
    
    /** display(MenuController)
     * 
     * Affiche le menu principal
     * @param nController
     */
    public void display(MenuController nController) {
    	this.mainController = nController;
        
        this.mainPanel = new JPanel();
        
        // composition des JComponent
        this.title = new JLabel("Titre");
        this.newGame = new JButton("Nouvelle Partie");
        this.saves = new JButton("Sauvegardes");
        this.quit = new JButton("Quitter");
        
        // placement des JComponent
        
        // habillage des JComponent 
        Color red = new Color(255,50,50);
        Insets button = new Insets(100,100,100,100);
        newGame.setBackground(red);
        newGame.setBorderPainted(false);
        newGame.setMargin(button);
        
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
    
    /** getNewGame()
     * 
     * @return Boutton newGame
     */
    public JButton getNewGame(){
        return newGame;
    }
    
    /** getSaves()
     * 
     * @return Boutton saves
     */
    public JButton getSaves(){
        return saves;
    }
    
    /** getQuit()
     * 
     * @return Boutton quit
     */
    public JButton getQuit(){
        return quit;
    }
    
    /** getMainFrame()
     * 
     * @return mainFrame
     */
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
}