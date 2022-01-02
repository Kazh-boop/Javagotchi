package app.model;

import java.util.Random;

public class Room { 

    private Weather currentWeather;
    private static final int AMOUNT_OF_WEATHER = 5;
    private Rooms currentRooms;

    // constructor
    public Room(Rooms selectedRoom) {
        this.currentRooms = selectedRoom;
        this.currentWeather = Weather.SUNNY;
    }

    public String getWeatherName() {
        return currentWeather.getName(); // return the weather 
    }

    public String getImageRoom() {
        return currentWeather.getUrl(); // return the image representing the room where the familiar is located
    }

    public float getWeatherCoef() {
        return currentWeather.getCoef(); // return the coefficient representing the weather
    }
    
    public Rooms getRooms()
    {
    	return currentRooms; // return the room where the familiar is located
    }
    
    public void setRooms(Rooms rooms)
    {
    	this.currentRooms = rooms; // allows you to change room
    }

    /**
     * method to change the weather randomly
     */
    public void changeWeather() {
         Random ran = new Random();

        int newWeather = ran.nextInt(100);
        if(newWeather < AMOUNT_OF_WEATHER ) {
            currentWeather = Weather.getWeatherById(newWeather);
        }
    }

    /**
     * return the Name of the room
      */
    public String getName() {
        return currentRooms.getName();
    }
    
    /**
     * method to change room by moving to the left 
     */
    public void moveLeft()
    {
    	int id = currentRooms.getId();
    	if(id > 0) {
    		id--;
    		currentRooms = currentRooms.getRoomByID(id);
    	}
    }
    
    /**
     *  method to change room by moving to the right
     */
    public void moveRight()
    {
    	int id = currentRooms.getId();
    	if(id < 2) {
    		id++;
    		currentRooms = currentRooms.getRoomByID(id);
    	}
    }
}
