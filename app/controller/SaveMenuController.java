package app.controller;

import app.model.SaveManager;
import app.view.MainFrame;
import app.view.SavesMenu;
import app.model.Cat;
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
	 * Constructeur
	 * @param menuController MenuController
	 * @param nFrame MainFrame
	 */
	public SaveMenuController(MenuController menuController, MainFrame nFrame) {
		this.mainFrame = nFrame;
		this.menuController = menuController;
		this.saveManager = new SaveManager("save/");
		this.savesMenu = new SavesMenu(nFrame);
	}
	
	/**
	 * Affiche le menu des sauvegardes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void savesMenuDisplay() throws ClassNotFoundException, IOException {
		flush();
		savesMenu.display(this);
	}
	
	public String[] getSaveName() {
		return saveManager.getNameSave();
	}
	
	public List<Familiar> getAllFamiliar() throws ClassNotFoundException, IOException {
		return saveManager.getAllFamiliar();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
    	if (e.getSource().equals(this.savesMenu.getBackMenu())) { // retour menu principal
    		this.onClickBackMenu();
    	}
    	else if (e.getSource().equals(this.savesMenu.getDeleteFamiliar())) { // suppression familier
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
	
	private void onClickBackMenu() {
		menuController.playsound(menuController.getClickSound());
		menuController.mainMenuDisplay();
	}
	
	private void onClickDeleteFamiliarButton() {
    	if (!(this.savesMenu.getListSave().isSelectionEmpty())) { // verification d'une selection
    		menuController.playsound(menuController.getClickSound());
    		Familiar f = this.savesMenu.getListSave().getSelectedValue(); // recuperation de la selcetion
    		int confirmDelete = JOptionPane.showConfirmDialog(
    				null, 
    				"Supprimer "+f.getName()+" le "+f.getFamiliarType()+" ?",
    				"Confirmer suppression",
    				JOptionPane.YES_NO_OPTION);
    		
    		if (confirmDelete == 0) { // oui == 0
        		menuController.playsound(menuController.getClickSound());
    			this.savesMenu.getModelFamiliar().removeElement(f); // suppression de l'affichage
    			this.saveManager.deleteSave(f.getUID()); // suppression du fichier de sauvegarde

    			this.savesMenu.getListSave().clearSelection(); // maj selection
    			this.savesMenu.disableToAction(); // desactivation des boutons d'actions sur la sauvegarde
    		} else // non
    			menuController.playsound(menuController.getClickSound());
    	}
	}
	
	private void onClickLoadSave() {
		menuController.playsound(menuController.getClickSound());
		if (!(this.savesMenu.getListSave().isSelectionEmpty())) { // verification d'une selection
    		Familiar familiarToLoad = this.savesMenu.getListSave().getSelectedValue(); // recuperation de la selcetion
			new GameController(familiarToLoad, mainFrame);
		}
	}
	
	/**
	 * Donne la mainFrame
	 * @return mainFrame MainFrame
	 */
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}
	
	/** 
	 * Vide la mainFrame de tous ses composants
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}
	
	public static void main(String[] args) throws IOException {
		SaveManager sm = new SaveManager("save/");
		Familiar f = new Cat("Filou");
		sm.openFile(f.getUID());
		sm.writeSave(f);
		
	}
	
}
