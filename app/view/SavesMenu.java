package app.view;

import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import app.controller.SaveMenuController;
import app.model.Familiar;


public class SavesMenu {
	
	private MainFrame mainFrame;
	private JPanel mainPanel;
	private SaveMenuController saveMController;
	
	private JButton deleteFamiliar;
	private JButton backMenu;
	private JLabel title;
	
	private DefaultListModel<Familiar> modelFamiliar;
	private JList<Familiar> listSave;
	private Vector<Familiar> allFamiliar;

    public SavesMenu(){}
	
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
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public void display(/*MenuController nController, */SaveMenuController smController) throws ClassNotFoundException, IOException {
    	//this.mainController = nController;
    	this.saveMController = smController;
        
        this.mainPanel = new JPanel();
        
        // recuperation des informations des familiers
        this.modelFamiliar = new DefaultListModel<>();
        this.allFamiliar = saveMController.getAllFamiliar();
        for (Familiar f : allFamiliar) modelFamiliar.addElement(f);

        // composition des JComponent
        this.listSave = new JList<>(modelFamiliar);
        this.title = new JLabel("Sauvegardes");
        this.backMenu = new JButton("Retour");
        this.deleteFamiliar = new JButton("Supprimer le familier sélectionné");
        
        
        // placement des JComponent
        
        // habillage des JComponent
        // listSave
        this.listSave.setFixedCellHeight(100);
        this.listSave.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // selectionner seul 1 element
        
        // creation des eventListener pour les JButton
        this.backMenu.addActionListener(this.saveMController);
        this.deleteFamiliar.addActionListener(this.saveMController);
        
        // ajout des elements dans la mainFrame
        mainPanel.add(backMenu);
        mainPanel.add(deleteFamiliar);
        mainPanel.add(title);
        mainPanel.add(listSave);
        
        mainFrame.add(mainPanel);
        
        
        mainFrame.setVisible(true);
    }
    
    public DefaultListModel<Familiar> getModelFamiliar() {
		return modelFamiliar;
	}

	public JList<Familiar> getListSave() {
		return listSave;
	}

	public JButton getDeleteFamiliar() {
		return this.deleteFamiliar;
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
