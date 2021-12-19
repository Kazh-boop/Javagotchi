package app.controller;

import app.model.SaveManager;
import app.model.Familiar;

import java.io.FileNotFoundException;
import java.io.IOException;

import app.model.Cat;

public class SaveMenuController {

	private SaveManager saveManager;

	public SaveMenuController() {
		this.saveManager = new SaveManager("save/");
	}

	public SaveManager getSaveManager() {
		return this.saveManager;
	}
	
	/**
	 * Tester la recuperation des informations
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SaveMenuController smc = new SaveMenuController();
		Familiar chat = new Cat("Filou");

		smc.getSaveManager().openStream("Filou");

		smc.getSaveManager().writeSave(chat);

		smc.getSaveManager().loadSave();
		
		System.out.println(smc.getSaveManager().getFamiliar().getFamiliarType()); // on doit voir "Chat" d'afficher

	}

}
