package app.controller;

import app.model.SaveManager;
import app.view.MainFrame;
import app.view.SavesMenu;
import app.model.Familiar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SaveMenuController implements ActionListener, ListSelectionListener {

	private MainFrame mainFrame;
	private SaveManager saveManager;
	private SavesMenu savesMenu;
	private MenuController menuController;
	
	/**
	 * Constructor
	 * @param menuController MenuController
	 * @param nFrame MainFrame
	 */
	public SaveMenuController(MenuController menuController, MainFrame nFrame) {
		this.mainFrame = nFrame;
		this.menuController = menuController;
		this.saveManager = new SaveManager();
		this.savesMenu = new SavesMenu(nFrame);
	}
	
	/**
	 * displays the backup menu
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void savesMenuDisplay() throws ClassNotFoundException, IOException {
		flush();
		savesMenu.display(this);
	}

	/**
	 * return all Name of familiar saved
	 */
	
	public String[] getSaveName() {
		return saveManager.getNameSave();
	}
	
	/**
	 * return all Familiar saved
	 */

	public List<Familiar> getAllFamiliar() throws ClassNotFoundException, IOException {
		return saveManager.getAllFamiliar();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
    	if (e.getSource().equals(this.savesMenu.getBackMenu())) { // back to main menu
    		this.onClickBackMenu();
    	}
    	else if (e.getSource().equals(this.savesMenu.getDeleteFamiliar())) { // deletion of the familiar
    		this.onClickDeleteFamiliarButton();
        }
    	else if (e.getSource().equals(this.savesMenu.getLoadSave())) {
    		this.onClickLoadSave();
    	}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
        if (!(e.getValueIsAdjusting())) {
        	this.menuController.playsound(menuController.getClickSound());
        	this.savesMenu.enableToAction();
        }
	}
	
	/**
	 * action when the button BackMenu is clicked
	  */
	private void onClickBackMenu() {
		menuController.playsound(menuController.getClickSound());
		menuController.mainMenuDisplay();
	}
	

	/**
	 * Action when the button DeleteFamiliar is clicked
	  */
	private void onClickDeleteFamiliarButton() {
    	if (!(this.savesMenu.getListSave().isSelectionEmpty())) { // checking a selection
    		menuController.playsound(menuController.getClickSound());
    		Familiar f = this.savesMenu.getListSave().getSelectedValue(); // recovery of a selection
    		int confirmDelete = JOptionPane.showConfirmDialog(
    				null, 
    				"Supprimer "+f.getName()+" le "+f.getFamiliarType()+" ?",
    				"Confirmer suppression",
    				JOptionPane.YES_NO_OPTION);
    		
    		if (confirmDelete == 0) { // yes == 0
        		menuController.playsound(menuController.getClickSound());
    			this.savesMenu.getModelFamiliar().removeElement(f); // removal of the display
    			this.saveManager.deleteSave(f.getUID()); // deleting the backup file

    			this.savesMenu.getListSave().clearSelection(); // update selection
    			this.savesMenu.disableToAction(); // disabling the action buttons on the backup
    		} else // no
    			menuController.playsound(menuController.getClickSound());
    	}
	}

	/**
	 * Action when the button LoadSave is clicked
	  */
	
	private void onClickLoadSave() {
		menuController.playsound(menuController.getClickSound());
		if (!(this.savesMenu.getListSave().isSelectionEmpty())) { // checking a selection
    		Familiar familiarToLoad = this.savesMenu.getListSave().getSelectedValue(); // recovery of a selection
			familiarToLoad.resetPosition();
			new GameController(familiarToLoad, mainFrame);
		}
	}
	
	/**
	 * Give the mainFrame
	 * @return mainFrame MainFrame
	 */
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}
	
	/** 
	 * Empty the mainFrame of all its components
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}
	
}
