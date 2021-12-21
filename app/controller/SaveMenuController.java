package app.controller;

import app.model.SaveManager;
import app.view.MainFrame;
import app.view.MainMenu;
import app.view.SavesMenu;
import app.model.Familiar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;


public class SaveMenuController implements ActionListener {

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
		this.savesMenu = new SavesMenu(this);
	}
	
	/**
	 * Affiche le menu des sauvegardes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void savesMenuDisplay() throws ClassNotFoundException, IOException {
		flush();
		savesMenu.display();
	}
	
	public String[] getSaveName() {
		return saveManager.getNameSave();
	}
	
	public Vector<Familiar> getAllFamiliar() throws ClassNotFoundException, IOException {
		return saveManager.getAllFamiliar();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
    	if (e.getSource().equals(this.savesMenu.getBackMenu())) { // retour menu principal
    		menuController.mainMenuDisplay();
    		
    	}else if(e.getSource().equals(this.savesMenu.getDeleteFamiliar())) { // suppression familier
    		this.onClickDeleteFamiliarButton();
        }
	}
	
	private void onClickDeleteFamiliarButton() {
    	if (!(this.savesMenu.getListSave().isSelectionEmpty())) { // verification d'une selection
    		Familiar f = this.savesMenu.getListSave().getSelectedValue(); // recuperation de la selcetion
    		this.savesMenu.getModelFamiliar().removeElement(f); // suppression de l'affichage
    		try {
				this.saveManager.deleteSave(f.getUID()); // suppression du fichier de sauvegarde
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
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
}
