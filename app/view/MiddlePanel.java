package app.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import app.model.Familiar;
import app.model.Room;
import app.controller.GameController;
import app.util.RoomsURL;
import app.util.BowlsURL;

public class MiddlePanel {
	private JLayeredPane pane;
	private JLabel background;
	private JLabel bowl = null;
	
	private Familiar familiar;
	private Room room;
	
	MiddlePanel(GameController gameController) {
		pane = new JLayeredPane();
		familiar = gameController.getFamiliar();
		room = gameController.getCurrentRoom();
		setup();	
		}
	
	private void setup() {
		String room_weather = room.getName() + room.getWeatherName();
		
		background = new JLabel(createImageIcon(RoomsURL.valueOf(room_weather).getURL()));
		background.setLocation(0, 0);
		background.setSize(background.getPreferredSize());
		pane.add(background, Integer.valueOf(0));
		
		if(room.getName() == "Cuisine") {
			String type_portions = familiar.getFamiliarType() + familiar.getPortions();
			bowl = new JLabel(createImageIcon(BowlsURL.valueOf(type_portions).getUrl()));
			pane.add(bowl, Integer.valueOf(1));
		}
	}
	
	public JLayeredPane getPane() {
		return pane;
	}
	
	private static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = NewGameMenu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
