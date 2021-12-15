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

    public SavesMenu(){}

    public SavesMenu(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
    
    public void display(MenuController nController, MainFrame nFrame) {
    	this.mainController = nController;
        this.mainFrame = nFrame;
        
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
    
    public JFrame getMainFrame(){
        return this.mainFrame;
    }

    public JButton getBackMenu(){
    	return this.backMenu;
	}
}
