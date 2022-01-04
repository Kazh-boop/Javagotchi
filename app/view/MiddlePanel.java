package app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import app.model.Familiar;
import app.model.Room;
import app.util.RoomsURL;
import app.util.BowlsURL;
import app.util.IconUtil;

public class MiddlePanel{
	private JLayeredPane pane;
	private JLabel backgroundIcon;
	private JLabel bowl = null;
	
	private Familiar familiar;
	private transient Room room;
	
	MiddlePanel(Familiar familiar, Room room) {
		pane = new JLayeredPane();
		this.familiar = familiar;
		this.room = room;
		setup();	
	}
	
	private void setup() {

		pane.removeAll();

		backgroundIcon = new JLabel(IconUtil.createImageIcon(RoomsURL.valueOf(getRoomWeather()).getURL()));
		backgroundIcon.setLocation(0, 0);
		backgroundIcon.setSize(backgroundIcon.getPreferredSize());
		pane.add(backgroundIcon, Integer.valueOf(0));
		
		if("Cuisine".equals(room.getName())) {
			String typePortions = familiar.getFamiliarType() + familiar.getPortions();
			bowl = new JLabel(IconUtil.createSizedImageIcon(BowlsURL.valueOf(typePortions).getUrl(), 150 , 100));
			bowl.setSize(bowl.getPreferredSize());
			bowl.setLocation(825, 500);
			pane.add(bowl, Integer.valueOf(1));
		}
	}
	
	public JLayeredPane getPane() {
		return pane;
	}

	private String getRoomWeather() {
		return room.getName() + room.getWeatherName();
	}

	public void changeRoom(Room newRoom) {
		this.room = newRoom;
		setup();
	}
	
}
