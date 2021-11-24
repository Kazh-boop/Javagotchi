import app.view.*;

public class Main {
    public static void main(String[] args) {
        new MainMenu();
        GamePanel gamePanel = new GamePanel();
        gamePanel.init();
    }
}