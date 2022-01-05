package app.view;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;

import app.model.Familiar;
import app.model.Room;
import app.util.RoomsURL;
import app.util.BowlsURL;
import app.util.CustomMenuLabel;
import app.util.IconUtil;

public class MiddlePanel{
	private JLayeredPane pane;
	private JLabel backgroundIcon;
	private JLabel familiarIcon;
	private JLabel sleepCompletion;
	private JProgressBar sleepPB;
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

		backgroundIcon = new JLabel(IconUtil.createSizedImageIcon(RoomsURL.valueOf(getRoomWeather()).getURL(),1000,630));
		backgroundIcon.setLocation(0, 0);
		backgroundIcon.setSize(backgroundIcon.getPreferredSize());
		pane.add(backgroundIcon, Integer.valueOf(0));
		
		switch(familiar.getFamiliarType()){
			case "Chat":
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/cat.png"));
				familiarIcon.setLocation(450, 355);
				break;
				
			case "Chien":
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/dog.png"));
				familiarIcon.setLocation(450, 360);
				break;
				
			case "Robot":
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/robot.png"));
				familiarIcon.setLocation(450, 345);
				break;
				
			case "Lapin":
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/rabbit.png"));
				familiarIcon.setLocation(450, 370);
				break;
				
			default:
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/cat.png"));
				familiarIcon.setLocation(450, 355);
				break;
		}
		
		familiarIcon.setSize(familiarIcon.getPreferredSize());
		pane.add(familiarIcon, Integer.valueOf(1));
		
		if("Cuisine".equals(room.getName())) {
			String typePortions = familiar.getFamiliarType() + familiar.getPortions();
			bowl = new JLabel(IconUtil.createSizedImageIcon(BowlsURL.valueOf(typePortions).getUrl(), 150 , 100));
			bowl.setSize(bowl.getPreferredSize());
			bowl.setLocation(825, 500);
			pane.add(bowl, Integer.valueOf(2));
		}
	}
	
	private void setupSleep() {

		pane.removeAll();

		backgroundIcon = new JLabel(IconUtil.createSizedImageIcon(RoomsURL.valueOf(getRoomWeather()).getURL(),1000,630));
		backgroundIcon.setLocation(0, 0);
		backgroundIcon.setSize(backgroundIcon.getPreferredSize());
		pane.add(backgroundIcon, Integer.valueOf(0));
		
		switch(familiar.getFamiliarType()){
			case "Chat":
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/cat_sleep.png"));
				familiarIcon.setLocation(450, 370);
				break;
				
			case "Chien":
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/dog_sleep.png"));
				familiarIcon.setLocation(450, 370);
				break;
				
			case "Robot":
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/robot_sleep.png"));
				familiarIcon.setLocation(380, 230);
				break;
				
			case "Lapin":
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/rabbit_sleep.png"));
				familiarIcon.setLocation(450, 370);
				break;
				
			default:
				familiarIcon = new JLabel(IconUtil.createImageIcon("../assets/images/cat_sleep.png"));
				familiarIcon.setLocation(450, 370);
				break;
		}
		familiarIcon.setSize(familiarIcon.getPreferredSize());
		pane.add(familiarIcon, Integer.valueOf(1));
		
		sleepCompletion = new CustomMenuLabel("Sommeil...");
		sleepCompletion.setLocation(300, 60);
		sleepCompletion.setSize(200, 50);;
		pane.add(sleepCompletion, Integer.valueOf(2));
		
		/*
		sleepPB = new JProgressBar(0, 100);
		sleepPB.setLocation(465, 65);
		sleepPB.setValue(0);
		sleepPB.setSize(sleepCompletion.getPreferredSize());
		pane.add(sleepPB, Integer.valueOf(3));
		*/
	}
	
	/**
	 * @return pane
	 */
	public JLayeredPane getPane() {
		return pane;
	}
	
	/**
	 * @return sleepPB
	 */
	public JProgressBar getSleepProgressBar() {
		return sleepPB;
	}
	
	/**
	 * @return Room + Weather
	 */
	private String getRoomWeather() {
		return room.getName() + room.getWeatherName();
	}
	
	/**
	 * Update the display
	 * @param newRoom
	 */
	public void changeRoom(Room newRoom) {
		this.room = newRoom;
		setup();
	}
	
	/**
	 * Update the display when sleeping
	 * @param newRoom
	 */
	public void sleep(Room newRoom) {
		this.room = newRoom;
		setupSleep();
	}
	
	/**
	 * Update the display when wake up
	 * @param newRoom
	 */
	public void wakeup(Room newRoom) {
		this.room = newRoom;
		setup();
	}
	
}
