package test.utility;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.model.Cat;
import app.model.Dog;
import app.model.Familiar;
import app.model.SaveManager;

public class TestSave {
	
	private Familiar saveFamiliarCat;
	private Familiar saveFamiliarDog;
	private SaveManager saveManager;
	
	private String nameSaveCat;
	private String nameSaveDog;
	private static final String ABSOLUTEPATH = "save/test/";
	private static final String EXTENSION = ".dat";
	private static final File rep = new File(ABSOLUTEPATH);


	@Before
	public void setUp() {
		saveManager = new SaveManager();
		rep.mkdirs();
		
		// Cat save
		saveFamiliarCat = new Cat("Filou");
		nameSaveCat = saveFamiliarCat.getUID();
		
		// Dog save
		saveFamiliarDog = new Dog("Toutou");
		nameSaveDog = saveFamiliarDog.getUID();
	}

	@After
	public void tearDown() {
		saveManager.deleteSave(nameSaveCat);
		saveManager.deleteSave(nameSaveDog);
		rep.delete();
		saveFamiliarCat = saveFamiliarDog = null;
		saveManager = null;
	}

	@Test
	public void saveFamiliar() throws IOException {
		// Cat
		saveManager.openFile(nameSaveCat); // ouverture du fichier
		saveManager.writeSave(saveFamiliarCat); // ecriture des infos de saveFamiliar dans TestSave.dat
		
		// Dog
		saveManager.openFile(nameSaveDog);
		saveManager.writeSave(saveFamiliarDog);
		
		assertEquals(true, new File(ABSOLUTEPATH+nameSaveCat+EXTENSION).exists()); // Check Cat
		assertEquals(true, new File(ABSOLUTEPATH+nameSaveDog+EXTENSION).exists()); // Check Dog
	}

}
