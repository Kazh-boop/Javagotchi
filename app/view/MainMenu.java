package app.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;

import app.controller.*;
import app.util.*;

public class MainMenu {
	
	protected static final float DEFAULT_BUTTON_SIZE = 32f;
	protected static final float DEFAULT_MAIN_BUTTON_SIZE = 48f;
	
	private MenuController mainController;
	private MainFrame mainFrame;
	private JPanel mainPanel;
	
	private CustomMenuLabel title;
	private CustomMenuButton newGame;
	private CustomMenuButton saves;
	private CustomMenuButton quit;
    
    /**
     * Constructor
     * @param nController MenuController
     */
    public MainMenu(MenuController nController){
    	this.mainController = nController;
    	this.mainFrame = mainController.getMainFrame();
    }
    
    /**
     * Displays the main menu
     * @param nController MenuController
     */
    public void display(MenuController nController) {
    	this.mainController = nController;
        
        this.mainPanel = new JPanel();
        
        // composition of JComponent
        this.title = new CustomMenuLabel("Tamagotchi", 96f, SwingConstants.CENTER);
        this.newGame = new CustomMenuButton("Nouvelle Partie", DEFAULT_MAIN_BUTTON_SIZE);
        this.saves = new CustomMenuButton("Sauvegardes", DEFAULT_MAIN_BUTTON_SIZE);
        this.quit = new CustomMenuButton("Quitter", DEFAULT_MAIN_BUTTON_SIZE);
        
        // customised clothing
        newGame.setForeground(CustomMenuButton.getColorGreen());
        saves.setForeground(CustomMenuButton.getColorGreen());
        quit.setForeground(Color.red);
        
        // creating eventListener for JButton
        this.newGame.addActionListener(this.mainController);
        this.saves.addActionListener(this.mainController);
        this.quit.addActionListener(this.mainController);
        
        // adding elements to the mainFrame
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
