package app.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Class allowing to manage the game saves<br>.
 * operating:
 * <ul>
 * 		<li>creation of the SaveManager 		-> new SaveManager(absolutePath)</li>
 * 		<li>opening the current file	-> openFile(nameSave)</li>
 * 		<li>writing to the file		-> writeSave(saveFamiliar)</li>
 * 		<li>lecture du fichier/donnees		-> loadSave()
 * 		<li>data recovery			-> loadFamiliar = this.getFamiliar() 
 * </ul>
 */
public class SaveManager {
	
    /**
     * allows you to write a serialized object (Familiar)
     */
    private ObjectOutputStream saveDatas;
    
    /**
     * Allows you to read a serialized object (Familiar)
     */
    private ObjectInputStream loadDatas;

    /**
     * Flow of writing to a file / also handles file creation automatically
     */
    private FileOutputStream dataOutStream;
    
    /**
     * Reading flow in a file
     */
    private FileInputStream dataInStream;
    
    /**
     * Path designating the location of the backups
     */
    private static final String DIRECTORY_PATH = "./save/";
    
    /**
     * Directory where the backups are located
     */
    private File repSave;
    
    /**
     * Current file in which the data will be written/read
     */
    private File currentFile;
    
    /**
     * Familiar whose information has been retrieved
     */
    private Familiar currentFamiliar;

    /**
     * Constructor
     * @param directoryPath String, initializes the directoryPath attribute 
     */
    public SaveManager() {
        this.repSave = new File(DIRECTORY_PATH);
        if (!(repSave.exists()))
        	repSave.mkdir();
    }

    /**
     * Allows you to design which file you are going to work on
     * @param saveName String, base of the name of the file to be saved
     * @throws FileNotFoundException
     */
    public void openFile(String saveName) {
    	currentFile = new File(DIRECTORY_PATH + saveName + ".dat");
    }

    /**
     * Allows you to create a file if none exists and write the data from f into it
     * @param f Familiar, familiar whose data is to be recorded
     * @throws IOException
     */
    public void writeSave(Familiar f) throws IOException {

    	if (isEnableToSave()) {
    		dataOutStream = new FileOutputStream(currentFile); // opening the file in write-only mode
    		saveDatas = new ObjectOutputStream(dataOutStream);

    		saveDatas.writeObject(f);

    		saveDatas.close();
    		dataOutStream.close();
    	}
    }

    /**
     * Delete a backup file
     * @param saveName String, name of the file to be deleted
     **/
    public void deleteSave(String saveName) {
        openFile(saveName);
        if (currentFile.exists())
            try {
                Files.delete(currentFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        else
        	System.err.println("le nom du fichier rentré n'est pas bon");
    }

    /**
     * Allows you to retrieve information from the currentFile and
     * copy them to currentFamiliar
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void loadSave() throws ClassNotFoundException, IOException {
        dataInStream = new FileInputStream(currentFile); // open the file in read-only mode
        loadDatas = new ObjectInputStream(dataInStream);
        
        currentFamiliar = (Familiar)loadDatas.readObject();

        loadDatas.close();
        dataInStream.close();
    }

    /**
     * accessor of the attribute currentFamiliar
     * @return currentFamiliar Familiar
     */
    public Familiar getFamiliar() {
        return currentFamiliar;
    }
    
    /**
     * Retrieves all backup names in the directoryPath by filtering them
     * @return listFileName String[], name of saves
     */
    public String[] getNameSave() {
    	File rep = new File(DIRECTORY_PATH);
    	return rep.list((dir, name) -> name.endsWith(".dat"));
    	
    }
    
    /**
     * Retrieves all familiar from each file and places them in a vector
     * @return listFamiliar Vector<Familiar>, vector containing the data saved in each file
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public List<Familiar> getAllFamiliar() throws ClassNotFoundException, IOException {
    	ArrayList<Familiar> listFamiliar = new ArrayList<>();
    	String[] listFileName = getNameSave();
    	
		for (String fileName: listFileName) {
			// retrieving information from the familiar
			openFile(getBaseName(fileName));
			loadSave();
			// is added to the vector
			listFamiliar.add(currentFamiliar);
		}
		
		return listFamiliar;
    }
    
    /**
     * Ensures that there are less than 3 backups
     * @return
     */
    public boolean isEnableToSave() {
    	return getNbSave() < 3;
    }
    
    /**
     * Allows to know the number of backup in the folder even if the user deletes it "by hand"
     * @return numbre of saves int
     */
    private int getNbSave() {
    	return (getNameSave() != null) ? getNameSave().length : 0;
    }
    
    /**
     * Allows you to retrieve the base name of a file name / remove the extension
     * @param name String, file name
     * @return file name without extension
     */
	private String getBaseName(String name) {
		return name.substring(0, name.lastIndexOf("."));
	}
	
}