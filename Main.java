
import app.model.*;
import app.view.*;
import app.controller.*;

public class Main {
    public static void main(String[] args) {
        MainFrame f = new MainFrame();

        new GameController(new Cat("Toto"), f);
    }
}

