package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSave {
	
	private Familiar saveFamiliarCat;
	private Familiar saveFamiliarDog;
	private SaveManager saveManager;
	
	private String nameSaveCat;
	private String nameSaveDog;
	private static final String ABSOLUTEPATH = "save/";
	private static final String EXTENSION = ".dat";
	private static final File rep = new File(ABSOLUTEPATH);
    private static final String CAT_URL = "/app/assets/images/cat.png";
    private static final String DOG_URL = "/app/assets/images/dog.png";



	@BeforeEach
	public void setUp() {
		saveManager = new SaveManager();
		rep.mkdirs();
		
		// Cat save
		saveFamiliarCat = new Cat("Filou", CAT_URL);
		nameSaveCat = saveFamiliarCat.getUID();
		
		// Dog save
		saveFamiliarDog = new Dog("Toutou", DOG_URL);
		nameSaveDog = saveFamiliarDog.getUID();
	}

	@AfterEach
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
