package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import util.*;

public class NewGameMenu {
	
	private static final int TOP_PANEL_HGAP = 50;
    private static final float TITLE_FONT_SIZE = 100f;
    private static final int NAME_MAX_CHAR = 16;

	private NewGameMenuController mainController;
	
	private MainFrame mainFrame;
	private JPanel mainPanel;
	
	private JPanel topPanel;
	private JPanel backPanel;
	private JPanel namePanel;
	private JPanel speciesNamePanel;
	private JPanel speciesPanel;
	private JPanel gamePanel;
	
	private JLabel title;
	private CustomMenuLabel textName;
	private JTextField name;
	private CustomMenuLabel textType;
	private JLabel speciesIcon;
	private CustomMenuButton backMenu;
	private JButton leftFamiliar;
	private JButton rightFamiliar;
	private CustomMenuButton launchGame;
	
	/**
	 * Constructor
	 * @param nController NewGameMenuController
	 */
    public NewGameMenu(NewGameMenuController nController){
    	this.mainController = nController;
    	this.mainFrame = mainController.getMainFrame();
    }

    /**
     * Displays the familiar creation menu
     */
    public void display() {
    	this.mainPanel = new JPanel();
        this.backPanel = new JPanel();
        this.topPanel = new JPanel();
        this.namePanel = new JPanel();
        this.speciesNamePanel = new JPanel();
        this.speciesPanel = new JPanel();
        this.gamePanel = new JPanel();
        
        // composition of JComponent
        this.backMenu = new CustomMenuButton("Retour",MainMenu.DEFAULT_BUTTON_SIZE);
        this.title = new CustomMenuLabel("Nouvelle Partie", TITLE_FONT_SIZE);
        this.textName = new CustomMenuLabel("Nom du familier :");
        this.name = new JTextField(null,NAME_MAX_CHAR);
        this.textType = new CustomMenuLabel("Choix de l'esp?ce de votre familier");
        this.leftFamiliar = new CustomMenuButton(IconUtil.createImageIcon("left.png"));
        this.speciesIcon = new JLabel(IconUtil.createImageIcon("cat.png"));
        this.rightFamiliar = new CustomMenuButton(IconUtil.createImageIcon("right.png"));
        this.launchGame = new CustomMenuButton("Lancer la partie",MainMenu.DEFAULT_BUTTON_SIZE);
        
        // JComponent wrapping
        this.launchGame.setForeground(CustomMenuButton.getColorGreen());
        this.leftFamiliar.setOpaque(false);
        this.leftFamiliar.setBorderPainted(false);
        this.rightFamiliar.setOpaque(false);
        this.rightFamiliar.setBorderPainted(false);
        
        // placement of JComponent
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, TOP_PANEL_HGAP, 0));
        
        // creation des eventListener pour les JButton
        this.backMenu.addActionListener(this.mainController);
        this.rightFamiliar.addActionListener(this.mainController);
        this.leftFamiliar.addActionListener(this.mainController);
        this.launchGame.addActionListener(this.mainController);
        
        // adding elements to the mainFrame
        backPanel.add(backMenu);
        topPanel.add(backPanel);
        topPanel.add(title);
        topPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        namePanel.add(textName);
        namePanel.add(name);
        
        speciesNamePanel.add(textType);
        speciesPanel.add(leftFamiliar);
        speciesPanel.add(speciesIcon);
        speciesPanel.add(rightFamiliar);
        
        gamePanel.add(launchGame);
        
        mainPanel.add(topPanel);
        mainPanel.add(namePanel);
        mainPanel.add(speciesNamePanel);
        mainPanel.add(speciesPanel);
        mainPanel.add(gamePanel);
        
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
    
// getter
    /**
     * @return mainFrame
     */
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
    
    /**
     * @return name
     */
    public JTextField getName(){
        return this.name;
    }
    
    /**
     * Return the button corresponding to the action of returning to the main menu
     * @return backMenu
     */
    public JButton getBackMenu(){
    	return this.backMenu;
    }

    /**
     * Return the button corresponding to the familiar change action
     * @return rightFamiliar
     */
    public JButton getRightFamiliarType(){
    	return this.rightFamiliar;
    }
    
    /**
     * @return leftFamiliar
     */
    public JButton getLeftFamiliarType(){
    	return this.leftFamiliar;
    }
    
    /**
     * @return speciesIcon
     */
    public JLabel getSpeciesIcon(){
    	return this.speciesIcon;
    }
    
    /**
     * @return launchGame
     */
    public JButton getLaunchGame(){
    	return this.launchGame;
    }

}
