package app.view;

import java.awt.*;
import javax.swing.*;
import app.controller.*;
public class NewGameMenu {
	
	private final int NAME_MAX_CHAR = 16;
	private MenuController mainController;
	
	private MainFrame mainFrame;
	private JPanel backPanel;
	private JPanel namePanel;
	private JPanel speciesNamePanel;
	private JPanel spiciesPanel;
	private JPanel gamePanel;
	
	private JTextField name;
	private JLabel texteName;
	private JLabel speciesIcon;
	private JButton backMenu;
	private JButton leftFamiliar;
	private JButton rightFamiliar;
	private JButton launchGame;

    public NewGameMenu(){}

    public void display(MenuController nController, MainFrame nFrame) {
    	this.mainController = nController;
        this.mainFrame = nFrame;
    	
        this.backPanel = new JPanel();
        this.namePanel = new JPanel();
        this.speciesNamePanel = new JPanel();
        this.spiciesPanel = new JPanel();
        this.gamePanel = new JPanel();
        
        // composition des JComponent
        this.name = new JTextField("Name",NAME_MAX_CHAR);
        this.texteName = new JLabel("Choix de l'espèce de votre familier");
        this.backMenu = new JButton("Retour");
        this.leftFamiliar = new JButton(createImageIcon("../image/left.png"));
        this.speciesIcon = new JLabel(createImageIcon("../image/cat.png"));
        this.rightFamiliar = new JButton(createImageIcon("../image/right.png"));
        this.launchGame = new JButton("Lancer la partie");
        
        // placement des JComponent
        
        // habillage des JComponent 
        
        // creation des eventListener pour les JButton
        this.backMenu.addActionListener(this.mainController);
        this.rightFamiliar.addActionListener(this.mainController);
        this.leftFamiliar.addActionListener(this.mainController);
        this.launchGame.addActionListener(this.mainController);
        
        // ajout des elements dans la mainFrame
        mainFrame.setLayout(new GridLayout(0, 1));
        backPanel.add(backMenu);
        namePanel.add(name);
        
        speciesNamePanel.add(texteName);
        spiciesPanel.add(leftFamiliar);
        spiciesPanel.add(speciesIcon);
        spiciesPanel.add(rightFamiliar);
        
        gamePanel.add(launchGame);
        
        mainFrame.add(backPanel);
        mainFrame.add(namePanel);
        mainFrame.add(speciesNamePanel);
        mainFrame.add(spiciesPanel);
        mainFrame.add(gamePanel);
        
        mainFrame.setVisible(true);
    }
    
// getter    
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
    
    public JLabel getSpeciesIcon() {
    	return this.speciesIcon;
    }
    
    public JButton getBackMenu(){
    	return this.backMenu;
    }
    
    public JButton getRightFamiliar(){
    	return this.rightFamiliar;
    }
    
    public JButton getLeftFamiliar(){
    	return this.leftFamiliar;
    }
    
    public JButton getLaunchGame(){
    	return this.launchGame;
    }
    
    private static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = NewGameMenu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public String getFamiliarName () {

        return name.getText();
    }
}
