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
	
	private void onClickBackMenu() {
		menuController.playsound(menuController.getClickSound());
		menuController.mainMenuDisplay();
	}
	
	private void onClickDeleteFamiliarButton() {
    	if (!(this.savesMenu.getListSave().isSelectionEmpty())) { // verification d'une selection
    		Familiar f = this.savesMenu.getListSave().getSelectedValue(); // recuperation de la selcetion
    		this.savesMenu.getModelFamiliar().removeElement(f); // suppression de l'affichage
    		this.saveManager.deleteSave(f.getUID()); // suppression du fichier de sauvegarde
    	}
	}
	
	private void onClickLoadSave() {
		// TODO lancer GameView
		// Faire un switch case comme dans le new game menu avec le type de familier
		// sauf qu'ici on passera directement le familier à charger au constructeur
		// Ensuite il y aura juste à faire l'appel de la vue exactement comme dans new game menu
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
