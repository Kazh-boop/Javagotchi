package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.SaveManager;

class TestLoad {

	private Familiar saveFamiliar, loadFamiliar;
	private SaveManager saveManager;
	
	private static String nameSave;
	private static final String ABSOLUTEPATH = "save/";
	
	@BeforeEach
	public void setUp() throws Exception {
		saveManager = new SaveManager(ABSOLUTEPATH);
		
		// Cat save
		saveFamiliar = new Cat("Filou");
		nameSave = saveFamiliar.getUID();
		saveManager.openFile(nameSave);
		saveManager.writeSave(saveFamiliar);
	}

	@AfterEach
	public void tearDown() throws Exception {
		saveManager.deleteSave(nameSave);
		saveFamiliar = loadFamiliar = null;
		saveManager = null;
	}

	/**
	 * Verification des donnees charges
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void loadSave() throws IOException, ClassNotFoundException {

		//chargement des informations
		saveManager.loadSave();
		loadFamiliar = saveManager.getFamiliar(); // recuperation du familier charge
		
		// comparaison des informations du familier sauvegarde et celui charger
		assertEquals(loadFamiliar.getUID(), saveFamiliar.getUID());
		assertEquals(loadFamiliar.getName(), saveFamiliar.getName());
		assertEquals(loadFamiliar.getHungriness(), saveFamiliar.getHungriness());
		assertEquals(loadFamiliar.getEnergy(), saveFamiliar.getEnergy());
		assertEquals(loadFamiliar.getHygiene(), saveFamiliar.getHygiene());
		assertEquals(loadFamiliar.getMood(), saveFamiliar.getMood());
		assertEquals(loadFamiliar.getPortions(), saveFamiliar.getPortions());
		assertEquals(loadFamiliar.getFamiliarType(), saveFamiliar.getFamiliarType());
	}
	
	/**
	 * verification que le changement est bon
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Test
	public void loadSaveChange() throws ClassNotFoundException, IOException {
		saveManager.loadSave();
		loadFamiliar = saveManager.getFamiliar();
		
		saveFamiliar.ResetPortion(); // changement de valeur : portion == 0
		saveManager.writeSave(saveFamiliar); // on sauvegarde le changement
		
		saveManager.loadSave();
		loadFamiliar = saveManager.getFamiliar(); // actualisation donnees de loadFamiliar
		
		assertEquals(loadFamiliar.getPortions(), saveFamiliar.getPortions());
		
	}

}
