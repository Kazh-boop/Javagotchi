
import javax.swing.JFrame;

import app.model.*;
import app.view.*;


public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Cat a = new Cat("prout");
        System.out.println(a.getHappiness());
    }
}
