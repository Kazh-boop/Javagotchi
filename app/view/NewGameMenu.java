package app.view;

import java.awt.*;
import javax.swing.*;
import app.controller.*;
import app.util.*;

public class NewGameMenu {
	
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
	 * Constructeur
	 * @param nController NewGameMenuController
	 */
    public NewGameMenu(NewGameMenuController nController){
    	this.mainController = nController;
    	this.mainFrame = mainController.getMainFrame();
    }

    /**
     * Affiche le menu de creation de familier
     */
    public void display() {
    	this.mainPanel = new JPanel();
        this.backPanel = new JPanel();
        this.topPanel = new JPanel();
        this.namePanel = new JPanel();
        this.speciesNamePanel = new JPanel();
        this.speciesPanel = new JPanel();
        this.gamePanel = new JPanel();
        
        // composition des JComponent
        this.backMenu = new CustomMenuButton("Retour",MainMenu.DEFAULT_BUTTON_SIZE);
        this.title = new CustomMenuLabel("Nouvelle Partie", 100f);
        this.textName = new CustomMenuLabel("Nom du familier :");
        this.name = new JTextField(null,NAME_MAX_CHAR);
        this.textType = new CustomMenuLabel("Choix de l'esp�ce de votre familier");
        this.leftFamiliar = new CustomMenuButton(createImageIcon("../assets/images/left.png"));
        this.speciesIcon = new JLabel(createImageIcon("../assets/images/cat.png"));
        this.rightFamiliar = new CustomMenuButton(createImageIcon("../assets/images/right.png"));
        this.launchGame = new CustomMenuButton("Lancer la partie",MainMenu.DEFAULT_BUTTON_SIZE);
        
        // habillage des JComponent
        this.launchGame.setForeground(CustomMenuButton.getColorGreen());
        this.leftFamiliar.setOpaque(false);
        this.leftFamiliar.setBorderPainted(false);
        this.rightFamiliar.setOpaque(false);
        this.rightFamiliar.setBorderPainted(false);
        
        // placement des JComponent
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 0));
        
        // creation des eventListener pour les JButton
        this.backMenu.addActionListener(this.mainController);
        this.rightFamiliar.addActionListener(this.mainController);
        this.leftFamiliar.addActionListener(this.mainController);
        this.launchGame.addActionListener(this.mainController);
        
        // ajout des elements dans la mainFrame
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
     * @return textField pour le nom du familier
     */
    public JTextField getName(){
        return this.name;
    }
    
    /**
     * @return Bouton correspondant a l'action de retour au menu principal
     */
    public JButton getBackMenu(){
    	return this.backMenu;
    }

    /**
     * @return Bouton correspondant a l'action de changement de familier
     */
    public JButton getRightFamiliarType(){
    	return this.rightFamiliar;
    }
    
    /**
     * @return leftFamiliar JButton
     */
    public JButton getLeftFamiliarType(){
    	return this.leftFamiliar;
    }
    
    /**
     * @return speciesIcon JLabel
     */
    public JLabel getSpeciesIcon(){
    	return this.speciesIcon;
    }
    
    /**
     * @return launchGame JButton
     */
    public JButton getLaunchGame(){
    	return this.launchGame;
    }
    
    /**
	 * Verifie que l'URL rentree mene bien vers un fichier
	 * @param path String
	 * @return imgURL ImageIcon
	 */
    private static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = NewGameMenu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
