package test;

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
	
	private Familiar saveFamiliarCat, saveFamiliarDog;
	private SaveManager saveManager;
	
	private static String nameSaveCat, nameSaveDog;
	private static final String ABSOLUTEPATH = "save/test/";
	private static final String EXTENSION = ".dat";
	private static final File rep = new File(ABSOLUTEPATH);


	@Before
	public void setUp() throws Exception {
		saveManager = new SaveManager(ABSOLUTEPATH);
		rep.mkdirs();
		
		// Cat save
		saveFamiliarCat = new Cat("Filou");
		nameSaveCat = saveFamiliarCat.getUID();
		
		// Dog save
		saveFamiliarDog = new Dog("Toutou");
		nameSaveDog = saveFamiliarDog.getUID();
	}

	@After
	public void tearDown() throws Exception {
		saveManager.deleteSave(nameSaveCat);
		saveManager.deleteSave(nameSaveDog);
		rep.delete();
		saveFamiliarCat = saveFamiliarDog = null;
		saveManager = null;
	}

	@Test
	public void saveFamiliar() throws IOException, ClassNotFoundException {
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
