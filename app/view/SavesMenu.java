package app.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.controller.MenuController;

public class SavesMenu {
	
	MenuController mainController;
	MainFrame mainFrame;
	JPanel mainPanel;
	
	JButton backMenu;
	JLabel title;
	
	/** SavesMenu(MainFrame)
	 * 
	 * Constructeur de SavesMenu
	 * @param nFrame
	 */
    public SavesMenu(MainFrame nFrame){
    	this.mainFrame = nFrame;
    }
    
    /** display(MenuController)
     * 
     * Affiche le menu des sauvegardes
     * @param nController
     */
    public void display(MenuController nController) {
    	this.mainController = nController;
        
        this.mainPanel = new JPanel();
        
        // composition des JComponent
        this.title = new JLabel("Sauvegardes");
        this.backMenu = new JButton("Retour");
        
        // placement des JComponent
        
        // habillage des JComponent
        
        // creation des eventListener pour les JButton
        this.backMenu.addActionListener(this.mainController);
        
        // ajout des elements dans la mainFrame
        mainPanel.add(backMenu);
        mainPanel.add(title);
        mainFrame.add(mainPanel);
        
        mainFrame.setVisible(true);
    }
    
    /** getMainFrame()
     * 
     * @return JFrame mainFrame
     */
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
    
    /** getBackMenu()
     * 
     * @return Boutton backMenu
     */
    public JButton getBackMenu(){
    	return this.backMenu;
	}
}
