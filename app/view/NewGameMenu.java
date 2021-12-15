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
	private JPanel speciesPanel;
	private JPanel gamePanel;
	
	private JLabel textName;
	private JTextField name;
	private JLabel textType;
	private JLabel speciesIcon;
	private JButton backMenu;
	private JButton leftFamiliar;
	private JButton rightFamiliar;
	private JButton launchGame;
	
	/** NewGameMenu(MainFrame)
	 * 
	 * Constructeur de NewGameMenu
	 * @param nFrame
	 */
    public NewGameMenu(MainFrame nFrame){
    	this.mainFrame = nFrame;
    }

    /** display(MenuController)
     * 
     * Affiche le menu de création de familier
     * @param nController
     */
    public void display(MenuController nController) {
    	this.mainController = nController;
    	
        this.backPanel = new JPanel();
        this.namePanel = new JPanel();
        this.speciesNamePanel = new JPanel();
        this.speciesPanel = new JPanel();
        this.gamePanel = new JPanel();
        
        // composition des JComponent
        this.textName = new JLabel("Nom du familier :");
        this.name = new JTextField("",NAME_MAX_CHAR);
        this.textType = new JLabel("Choix de l'espèce de votre familier");
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
        namePanel.add(textName);
        namePanel.add(name);
        
        speciesNamePanel.add(textType);
        speciesPanel.add(leftFamiliar);
        speciesPanel.add(speciesIcon);
        speciesPanel.add(rightFamiliar);
        
        gamePanel.add(launchGame);
        
        mainFrame.add(backPanel);
        mainFrame.add(namePanel);
        mainFrame.add(speciesNamePanel);
        mainFrame.add(speciesPanel);
        mainFrame.add(gamePanel);
        
        mainFrame.setVisible(true);
    }
    
// getter
    /** getMainFrame()
     * 
     * @return mainFrame
     */
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
    
    /** getMainFrame()
     * 
     * @return textField pour le nom du familier
     */
    public JTextField getName(){
        return this.name;
    }
    
    /** getMainFrame()
     * 
     * @return Bouton correspondant a l'action de retour au menu principal
     */
    public JButton getBackMenu(){
    	return this.backMenu;
    }

    /** getMainFrame()
     * 
     * @return Bouton correspondant a l'action de changement de familier
     */
    public JButton getRightFamiliarType(){
    	return this.rightFamiliar;
    }
    
    /** getMainFrame()
     * 
     * @return Bouton correspondant a l'action de changement de familier
     */
    public JButton getLeftFamiliarType(){
    	return this.leftFamiliar;
    }
    
    /** getMainFrame()
     * 
     * @return JLabel correspondant à l'image du familier selectionne
     */
    public JLabel getSpeciesIcon(){
    	return this.speciesIcon;
    }
    
    /** getLaunchGame()
     * 
     * @return Buton correspondant a l'action launchGame
     */
    public JButton getLaunchGame(){
    	return this.launchGame;
    }
    
    /** createImageIcon(String)
	 * 
	 * Verifie que l'URL rentree mene bien vers un fichier
	 * @return ImageIcon à partir du fichier source
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
