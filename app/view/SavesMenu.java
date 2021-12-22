package app.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import app.controller.SaveMenuController;
import app.model.Familiar;


public class SavesMenu {
	
	private MainFrame mainFrame;
	private JPanel mainPanel;
	private SaveMenuController saveMController;
	
	// top panel
	private JPanel panTop;
	// titre du menu
	private JLabel title;
	// retour menu
	private JPanel panBackMenu;
	private JButton backMenu;
	
	// liste des sauvegardes
	private JPanel panList;
	private DefaultListModel<Familiar> modelFamiliar;
	private JList<Familiar> listSave;
	private Vector<Familiar> allFamiliar;
	
	// Actions sur le familier
	private JPanel panActionOnFamiliar;
	// suppression du familier
	private JButton deleteFamiliar;
	// chargement de la sauvegarde
	private JButton loadSave;
	

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
    public void display(SaveMenuController smController) throws ClassNotFoundException, IOException {

    	this.saveMController = smController;
        
        this.mainPanel = new JPanel(new BorderLayout(0, 100));
        this.panTop = new JPanel(new FlowLayout(FlowLayout.LEADING, 100, 0));
        this.panBackMenu = new JPanel();
        this.panList = new JPanel();
        this.panActionOnFamiliar = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
        
        // recuperation des informations des familiers
        this.modelFamiliar = new DefaultListModel<Familiar>();
        this.allFamiliar = saveMController.getAllFamiliar();
        for (Familiar f : allFamiliar) modelFamiliar.addElement(f);

        // composition des JComponent
        this.title = new CustomMenuLabel("Sauvegardes", 100f);
        this.listSave = new JList<Familiar>(modelFamiliar);
        this.backMenu = new CustomMenuButton("Retour", 32f);
        this.deleteFamiliar = new CustomMenuButton("Supprimer", 32f);
        this.loadSave = new CustomMenuButton("Charger", 32f);
        
        
        // placement des JComponent
        
        // habillage des JComponent
        // listSave
        this.listSave.setCellRenderer(new ListFamiliarRenderer());
        
        // creation des eventListener pour les JButton
        this.backMenu.addActionListener(this.saveMController);
        this.deleteFamiliar.addActionListener(this.saveMController);
        this.loadSave.addActionListener(this.saveMController);
        
        // ajout des elements dans la mainFrame
        // affichage au top
        panBackMenu.add(backMenu);
        panTop.add(panBackMenu);
        panTop.add(title);
        // affichage au centre
        panList.add(listSave);
        // affichage en bas
        panActionOnFamiliar.add(deleteFamiliar);
        panActionOnFamiliar.add(loadSave);
        // ajout des elements dans la mainPanel
        mainPanel.add(panTop, BorderLayout.NORTH);
        mainPanel.add(panList, BorderLayout.CENTER);
        mainPanel.add(panActionOnFamiliar, BorderLayout.SOUTH);
        // ajout du mainPanel dans la fram
        mainFrame.add(mainPanel);
        
        
        mainFrame.setVisible(true);
    }
    
    public DefaultListModel<Familiar> getModelFamiliar() {
		return modelFamiliar;
	}

	public JList<Familiar> getListSave() {
		return listSave;
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
    
	public JButton getDeleteFamiliar() {
		return this.deleteFamiliar;
	}

	/**
	 * @return the loadSave
	 */
	public JButton getLoadSave() {
		return loadSave;
	}

}
