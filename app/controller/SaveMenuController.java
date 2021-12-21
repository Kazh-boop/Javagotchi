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

	public SaveMenuController(MainFrame mf) {
		this.mainFrame = mf;
		this.saveManager = new SaveManager("save/");
		this.savesMenu = new SavesMenu(mainFrame);
	}
	
	public void savesMenuDisplay() throws ClassNotFoundException, IOException {
		savesMenu.display(this);
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
    		// TODO revenir au menu principal
    	}

    	else if(e.getSource().equals(this.savesMenu.getDeleteFamiliar())) { // suppression familier
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
	
}
