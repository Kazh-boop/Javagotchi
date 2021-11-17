package app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import app.model.Cat;

public class SaveController {
    
    public SaveController(String saveName) {
        try {

            FileOutputStream fos = new FileOutputStream("save/"+ saveName +".dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            Cat user = new Cat("FFFF");

            // write object to file
            oos.writeObject(user);
            oos.reset();

            fos.close();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteSave(String saveName) {
        File f = new File("save/" + saveName + ".dat");
        f.delete();
        
    }

    public void loadSave(String saveName) throws ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(new File("save/"+saveName+".dat"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            Cat c = (Cat) ois.readObject();
            System.out.println(c.getFood());
            
            fis.close();
            ois.close();
        } catch (IOException ex) {

        }
    }
}
