package app.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveManager implements Serializable {
    
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
        switch(((Familiar)loadDatas.readObject()).getFamiliarType()) {
            case "Chat" : 
                currentFamiliar = new Cat((Cat) loadDatas.readObject());
                break;
            case "Robot":
                currentFamiliar = new Robot((Robot) loadDatas.readObject());
                break;
            case "Lapin":
                currentFamiliar = new Rabbit((Rabbit) loadDatas.readObject());
                break;
        }
        loadDatas.close();
    }

    public Familiar getFamiliar() {
        return currentFamiliar;
    }
}