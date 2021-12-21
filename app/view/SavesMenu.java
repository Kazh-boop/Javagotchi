package app.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.controller.SaveMenuController;

public class SavesMenu {
	
	SaveMenuController mainController;
	MainFrame mainFrame;
	JPanel mainPanel;
	
	JButton backMenu;
	JLabel title;
	
	/** SavesMenu(MainFrame)
	 * 
	 * Constructeur de SavesMenu
	 * @param nFrame
	 */
    public SavesMenu(SaveMenuController nController){
    	this.mainController = nController;
    	this.mainFrame = mainController.getMainFrame();
    }
    
    /** display(MenuController)
     * 
     * Affiche le menu des sauvegardes
     * @param nController
     */
    public void display() {        
        this.mainPanel = new JPanel();
        
        // composition des JComponent
        this.title = new JLabel("Sauvegardes");
        this.backMenu = new JButton("Retour");
        
        // creation des eventListener pour les JButton
        this.backMenu.addActionListener(this.mainController);
        
        // ajout des elements dans la mainFrame
        mainPanel.add(backMenu);
        mainPanel.add(title);
        mainFrame.add(mainPanel);
        
        mainFrame.setVisible(true);
    }
    
    /**
     * @return JFrame mainFrame
     */
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
    
    /**
     * @return Boutton backMenu
     */
    public JButton getBackMenu(){
    	return this.backMenu;
	}
}
