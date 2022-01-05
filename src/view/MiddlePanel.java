package view;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;

import model.Familiar;
import model.Room;
import util.RoomsURL;
import util.BowlsURL;
import util.CustomMenuLabel;
import util.IconUtil;

public class MiddlePanel{
	private JLayeredPane pane;
	private JLabel backgroundIcon;
	private JLabel familiarIcon;
	private JLabel sleepCompletion;
	private JProgressBar sleepPB;
	private JLabel bowl = null;
	
	private Familiar familiar;
	private transient Room room;
	
	/**
	 * Constructor
	 * @param familiar
	 * @param room
	 */
	MiddlePanel(Familiar familiar, Room room) {
		pane = new JLayeredPane();
		this.familiar = familiar;
		this.room = room;
		setup();	
	}
	
	/**
	 * Add the game background to the pane displayed
	 */
	private void setupBackground() {
		backgroundIcon = new JLabel(IconUtil.createSizedImageIcon(RoomsURL.valueOf(getRoomWeather()).getURL(),1000,630));
		backgroundIcon.setLocation(0, 0);
		backgroundIcon.setSize(backgroundIcon.getPreferredSize());
		pane.add(backgroundIcon, Integer.valueOf(0));
	}
	
	/**
	 * Display the game panel by layering the background, the familiar and the other part that could be displayed
	 */
	private void setup() {

		pane.removeAll();

		setupBackground();
		
		switch(familiar.getFamiliarType()){
			case "Chat":
				familiarIcon = new JLabel(IconUtil.createImageIcon("cat.png"));
				familiarIcon.setLocation(450, 355);
				break;
				
			case "Chien":
				familiarIcon = new JLabel(IconUtil.createImageIcon("dog.png"));
				familiarIcon.setLocation(450, 360);
				break;
				
			case "Robot":
				familiarIcon = new JLabel(IconUtil.createImageIcon("robot.png"));
				familiarIcon.setLocation(450, 345);
				break;
				
			case "Lapin":
				familiarIcon = new JLabel(IconUtil.createImageIcon("rabbit.png"));
				familiarIcon.setLocation(450, 350);
				break;
				
			default:
				familiarIcon = new JLabel(IconUtil.createImageIcon("cat.png"));
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
	
	/**
	 * Display the game panel by layering the background, the familiar and the other part that could be displayed
	 * only called when the familiar is sleeping
	 */
	private void setupSleep() {

		pane.removeAll();

		setupBackground();
		
		switch(familiar.getFamiliarType()){
			case "Chat":
				familiarIcon = new JLabel(IconUtil.createImageIcon("cat_sleep.png"));
				familiarIcon.setLocation(10, 340);
				break;
				
			case "Chien":
				familiarIcon = new JLabel(IconUtil.createImageIcon("dog_sleep.png"));
				familiarIcon.setLocation(450, 370);
				break;
				
			case "Robot":
				familiarIcon = new JLabel(IconUtil.createImageIcon("robot_sleep.png"));
				familiarIcon.setLocation(380, 230);
				break;
				
			case "Lapin":
				familiarIcon = new JLabel(IconUtil.createImageIcon("rabbit_sleep.png"));
				familiarIcon.setLocation(89, 266);
				break;
				
			default:
				familiarIcon = new JLabel(IconUtil.createImageIcon("cat_sleep.png"));
				familiarIcon.setLocation(10, 340);
				break;
		}
		familiarIcon.setSize(familiarIcon.getPreferredSize());
		pane.add(familiarIcon, Integer.valueOf(1));
		
		sleepCompletion = new CustomMenuLabel("Sommeil...");
		sleepCompletion.setLocation(300, 60);
		sleepCompletion.setSize(200, 50);;
		pane.add(sleepCompletion, Integer.valueOf(2));
		
		sleepPB = new JProgressBar(0, 100);
		sleepPB.setLocation(465, 62);
		sleepPB.setValue(0);
		sleepPB.setSize(sleepCompletion.getPreferredSize());
		pane.add(sleepPB, Integer.valueOf(3));
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
	 * @return familiarIcon
	 */
	public JLabel getFamiliarIcon() {
		return familiarIcon;
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
