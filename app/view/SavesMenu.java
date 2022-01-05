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
	// menu title
	private JLabel title;
	// back to menu
	private JPanel panBackMenu;
	private JButton backMenu;
	
	// list of backups
	private JPanel panList;
	private DefaultListModel<Familiar> modelFamiliar;
	private JList<Familiar> listSave;
	private List<Familiar> allFamiliar;
	
	// Actions on the familiar
	private JPanel panActionOnFamiliar;
	// deletion of the familiar
	private JButton deleteFamiliar;
	// loading the backup
	private JButton loadSave;	

    public SavesMenu(){}
	
	/**
	 * Constructor
	 * @param nFrame
	 */
    public SavesMenu(MainFrame nFrame){
    	this.mainFrame = nFrame;
    }
    
    /**
     * Displays the backup menu
     * @param smController SaveMenuController
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
        
        // retrieving information from familiar
        this.modelFamiliar = new DefaultListModel<>();
        this.allFamiliar = saveMController.getAllFamiliar();
        for (Familiar f : allFamiliar) modelFamiliar.addElement(f);

        // composition of JComponents 
        this.title = new CustomMenuLabel("Sauvegardes", 100f);
        this.backMenu = new CustomMenuButton("Retour",MainMenu.DEFAULT_BUTTON_SIZE);
        this.listSave = new JList<>(modelFamiliar);
        this.deleteFamiliar = new CustomMenuButton("Supprimer",MainMenu.DEFAULT_BUTTON_SIZE);
        this.loadSave = new CustomMenuButton("Charger",MainMenu.DEFAULT_BUTTON_SIZE);
        
        // placement of JComponents
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.panTop.setLayout(new FlowLayout(FlowLayout.LEADING, 100, 0));
        this.panActionOnFamiliar.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        
        // JComponent wrapping
        // listSave
        this.listSave.setCellRenderer(new ListFamiliarRenderer()); 
        // familiar action buttons
        this.deleteFamiliar.setForeground(Color.RED);
        this.deleteFamiliar.setEnabled(false);
        this.loadSave.setForeground(CustomMenuButton.getColorGreen());
        this.loadSave.setEnabled(false);
        
        // creation of eventListener
        this.backMenu.addActionListener(this.saveMController);
        this.deleteFamiliar.addActionListener(this.saveMController);
        this.loadSave.addActionListener(this.saveMController);
        this.listSave.addListSelectionListener(this.saveMController);
        
        // adding elements to the mainFrame
        // top-notch display
        panBackMenu.add(backMenu);
        panTop.add(panBackMenu);
        panTop.add(title);
        panTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        // display in the centre
        panList.add(listSave);
        panList.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // bottom display
        panActionOnFamiliar.add(deleteFamiliar);
        panActionOnFamiliar.add(loadSave);
        panActionOnFamiliar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // adding elements to the mainPanel
        mainPanel.add(panTop);
        mainPanel.add(panList);
        mainPanel.add(panActionOnFamiliar);
        // add the mainPanel to the frame
        mainFrame.add(mainPanel);
        
        mainFrame.setVisible(true);
    }
    
    /**
     * @return modelFamiliar
     */
    public DefaultListModel<Familiar> getModelFamiliar() {
		return modelFamiliar;
	}
    
    /**
     * @return listSave
     */
	public JList<Familiar> getListSave() {
		return listSave;
	}

	/**
     * @return mainFrame
     */
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
    
    /**
     * @return backMenu
     */
    public JButton getBackMenu(){
    	return this.backMenu;
	}
    
    /**
     * @return deleteFamiliar
     */
	public JButton getDeleteFamiliar() {
		return deleteFamiliar;
	}

	/**
	 * @return loadSave
	 */
	public JButton getLoadSave() {
		return loadSave;
	}
	
	/**
	 * Settings for displaying the action buttons on backups when selecting from the list
	 */
	public void enableToAction() {
        this.deleteFamiliar.setEnabled(true);
        this.loadSave.setEnabled(true);
	}
	
	/**
	 * Settings for displaying action buttons on backups when there are no selections in the list
	 */
	public void disableToAction() {
        this.deleteFamiliar.setEnabled(false);
        this.loadSave.setEnabled(false);
	}

}
