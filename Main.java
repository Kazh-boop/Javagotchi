import app.model.Familiar;
import app.model.Rabbit;
import app.view.*;
import app.controller.*;

public class Main {
    public static void main(String[] args) {
        //new MainMenu();
        GamePanel gamePanel = new GamePanel();
        gamePanel.init();
        Familiar familiar = new Rabbit("Panpan");
    }
}
