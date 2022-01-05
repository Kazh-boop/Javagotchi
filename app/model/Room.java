package app.model;

import java.util.Random;

public class Room { 

    private Weather currentWeather;
    private static final int AMOUNT_OF_WEATHER = 5;
    private Rooms currentRooms;

    /**
     * Constructor
     * @param selectedRoom
     */
    public Room(Rooms selectedRoom) {
        this.currentRooms = selectedRoom;
        this.currentWeather = Weather.SUNNY;
    }

    /**
     * Return the current weather name
     * @return weather
     */
    public String getWeatherName() {
        return currentWeather.getName(); 
    }

    /**
     * return the image representing the room where the familiar is located
     * @return url
     */
    public String getImageRoom() {
        return currentWeather.getUrl();
    }

    /**
     * return the coefficient representing the weather
     * @return coef
     */
    public float getWeatherCoef() {
        return currentWeather.getCoef();
    }
    
    /**
     * return the room where the familiar is located
     * @return currentRooms
     */
    public Rooms getRooms()
    {
    	return currentRooms;
    }
    
    /**
     * allows you to change room
     * @param rooms
     */
    public void setRooms(Rooms rooms)
    {
    	this.currentRooms = rooms;
    }

    /**
     * method to change the weather randomly
     * @return boolean
     */
    public boolean changeWeather() {
        int newWeather = new Random().nextInt(100);

        if(newWeather < AMOUNT_OF_WEATHER ) {
            currentWeather = Weather.getWeatherById(newWeather);
            return true;
        }
        return false;
    }

    /**
     * return the Name of the room
     * @return Room's name
     */
    public String getName() {
        return currentRooms.getName();
    }
    
    /**
     * method to change room by moving to the left
     * @return boolean
     */
    public boolean moveLeft()
    {
    	int id = currentRooms.getId();
    	if(id > 0) {
    		id--;
    		currentRooms = currentRooms.getRoomByID(id);
            return true;
    	}
        return false;
    }
    
    /**
     * method to change room by moving to the right
     * @return boolean
     */
    public boolean moveRight()
    {
    	int id = currentRooms.getId();
    	if(id < 2) {
    		id++;
    		currentRooms = currentRooms.getRoomByID(id);
            return true;
    	}
        return false;
    }
}
