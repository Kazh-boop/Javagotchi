package app.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveManager {
    
    private ObjectOutputStream saveDatas;
    private ObjectInputStream loadDatas;

    private FileOutputStream dataOutStream;
    private FileInputStream dataInStream;
    private String directoryPath;
    
    private Familiar currentFamiliar;

    public SaveManager(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void openStream(String saveName) throws FileNotFoundException {
        dataOutStream = new FileOutputStream( directoryPath + saveName + ".dat");
        dataInStream = new FileInputStream(directoryPath + saveName + ".dat");
    }

    public void writeSave(Familiar f) throws IOException {
        saveDatas = new ObjectOutputStream(dataOutStream);
        saveDatas.writeObject(f);

        dataOutStream.close();
    }

    public void deleteSave(String saveName) {
        File f = new File("save/" + saveName + ".dat");
        f.delete();   
    }

    public void loadSave() throws ClassNotFoundException, IOException {
        loadDatas = new ObjectInputStream(dataInStream);
        currentFamiliar = ((Familiar)loadDatas.readObject()); // recuperation de l'objet / du familier
        /*
         * Ce qui l'y a en dessous provoque un EOFException parce qu'on recupere l'objet une premiere fois dans 
         * la condition du switch puis on essaie de recuperer un autre objet qui n'est pas enregistre
         */
        
        /*
        switch(((Familiar)loadDatas.readObject()).getFamiliarType()) {
            case "Chat" : 
            	System.out.println("here");
                currentFamiliar = new Cat((Cat) loadDatas.readObject()); // End Of File Exception
                break;
            case "Robot":
                currentFamiliar = new Robot((Robot) loadDatas.readObject());
                break;
            case "Lapin":
                currentFamiliar = new Rabbit((Rabbit) loadDatas.readObject());
                break;
            case "Chien":
            	currentFamiliar = new Dog((Dog) loadDatas.readObject());
        }*/
        
        loadDatas.close();
    }

    public Familiar getFamiliar() {
        return currentFamiliar;
    }
}