package test.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.model.Cat;
import app.model.Familiar;
import app.model.SaveManager;

class TestLoad {

	private Familiar saveFamiliar;
	private Familiar loadFamiliar;
	private SaveManager saveManager;
	
	private String nameSave;
	private static final String ABSOLUTEPATH = "save/test/";
	private static final File rep = new File(ABSOLUTEPATH);
    private static final String CAT_URL = "/app/assets/images/cat.png";

	
	@BeforeEach
	public void setUp() throws Exception {
		saveManager = new SaveManager();
		rep.mkdirs();

		// Cat save
		saveFamiliar = new Cat("Filou", CAT_URL);
		nameSave = saveFamiliar.getUID();
		saveManager.openFile(nameSave);
		saveManager.writeSave(saveFamiliar);
	}

	@AfterEach
	public void tearDown() {
		saveManager.deleteSave(nameSave);
		rep.delete();
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
		assertEquals(saveFamiliar.getUID(), loadFamiliar.getUID());
		assertEquals(saveFamiliar.getName(), loadFamiliar.getName());
		assertEquals(saveFamiliar.getHungriness(), loadFamiliar.getHungriness());
		assertEquals(saveFamiliar.getEnergy(), loadFamiliar.getEnergy());
		assertEquals(saveFamiliar.getHygiene(), loadFamiliar.getHygiene());
		assertEquals(saveFamiliar.getMood(), loadFamiliar.getMood());
		assertEquals(saveFamiliar.getPortions(), loadFamiliar.getPortions());
		assertEquals(saveFamiliar.getFamiliarType(), loadFamiliar.getFamiliarType());
		
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
		
		saveFamiliar.resetPortion(); // changement de valeur : portion == 0
		saveManager.writeSave(saveFamiliar); // on sauvegarde le changement
		
		saveManager.loadSave();
		loadFamiliar = saveManager.getFamiliar(); // actualisation donnees de loadFamiliar
		
		assertEquals(saveFamiliar.getPortions(), loadFamiliar.getPortions());
		
	}

}
