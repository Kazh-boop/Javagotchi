package app.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import app.controller.SaveMenuController;
import app.model.Familiar;
import app.util.*;


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
	private List<Familiar> allFamiliar;
	
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
        
        this.mainPanel = new JPanel();
        this.panTop = new JPanel();
        this.panBackMenu = new JPanel();
        this.panList = new JPanel();
        this.panActionOnFamiliar = new JPanel();
        
        // recuperation des informations des familiers
        this.modelFamiliar = new DefaultListModel<>();
        this.allFamiliar = saveMController.getAllFamiliar();
        for (Familiar f : allFamiliar) modelFamiliar.addElement(f);

        // composition des JComponent
        this.title = new CustomMenuLabel("Sauvegardes", 100f);
        this.backMenu = new CustomMenuButton("Retour",MainMenu.DEFAULT_BUTTON_SIZE);
        this.listSave = new JList<>(modelFamiliar);
        this.deleteFamiliar = new CustomMenuButton("Supprimer",MainMenu.DEFAULT_BUTTON_SIZE);
        this.loadSave = new CustomMenuButton("Charger",MainMenu.DEFAULT_BUTTON_SIZE);
        
        // placement des JComponent
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.panTop.setLayout(new FlowLayout(FlowLayout.LEADING, 100, 0));
        this.panActionOnFamiliar.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        
        // habillage des JComponent
        // listSave
        this.listSave.setCellRenderer(new ListFamiliarRenderer()); 
        // boutons d'actions du familier
        this.deleteFamiliar.setForeground(Color.RED);
        this.deleteFamiliar.setEnabled(false);
        this.loadSave.setForeground(CustomMenuButton.getColorGreen());
        this.loadSave.setEnabled(false);
        
        // creation des eventListener
        this.backMenu.addActionListener(this.saveMController);
        this.deleteFamiliar.addActionListener(this.saveMController);
        this.loadSave.addActionListener(this.saveMController);
        this.listSave.addListSelectionListener(this.saveMController);
        
        // ajout des elements dans la mainFrame
        // affichage au top
        panBackMenu.add(backMenu);
        panTop.add(panBackMenu);
        panTop.add(title);
        panTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        // affichage au centre
        panList.add(listSave);
        panList.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // affichage en bas
        panActionOnFamiliar.add(deleteFamiliar);
        panActionOnFamiliar.add(loadSave);
        panActionOnFamiliar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // ajout des elements dans la mainPanel
        mainPanel.add(panTop);
        mainPanel.add(panList);
        mainPanel.add(panActionOnFamiliar);
        // ajout du mainPanel dans la frame
        mainFrame.add(mainPanel);
        
        mainFrame.setVisible(true);
    }
    
    /**
     * @return the modelFamiliar
     */
    public DefaultListModel<Familiar> getModelFamiliar() {
		return modelFamiliar;
	}
    
    /**
     * @return the listSave
     */
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
     * @return Button backMenu
     */
    public JButton getBackMenu(){
    	return this.backMenu;
	}
    
    /**
     * @return the deleteFamiliar
     */
	public JButton getDeleteFamiliar() {
		return deleteFamiliar;
	}

	/**
	 * @return the loadSave
	 */
	public JButton getLoadSave() {
		return loadSave;
	}
	
	/**
	 * Parametres d'affichage des boutons d'actions sur les sauvegardes lors d'une selection dans la liste
	 */
	public void enableToAction() {
        this.deleteFamiliar.setEnabled(true);
        this.loadSave.setEnabled(true);
	}
	
	/**
	 * Parametres d'affichage des boutons d'actions sur les sauvegardes lorsqu'il n'y a pas de selections dans la liste
	 */
	public void disableToAction() {
        this.deleteFamiliar.setEnabled(false);
        this.loadSave.setEnabled(false);
	}

}
