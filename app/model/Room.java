package app.model;

import java.util.Random;

public class Room { 

    private Weather currentWeather;
    private static final int AMOUNT_OF_WEATHER = 5;
    public Rooms currentRooms;

    public Room(Rooms selectedRoom) {
        this.currentRooms = selectedRoom;
        this.currentWeather = Weather.SUNNY;
    }

    public String getWeatherName() {
        return currentWeather.getName();
    }

    public String getImageRoom() {
        return currentWeather.getUrl();
    }

    public float getWeatherCoef() {
        return currentWeather.getCoef();
    }
    
    public Rooms getRooms()
    {
    	return currentRooms;
    }
    
    public void setRooms(Rooms rooms)
    {
    	this.currentRooms = rooms;
    }

    public void changeWeather() {
         Random ran = new Random();

        int newWeather = (int) (ran.nextInt(100));
        if(newWeather < AMOUNT_OF_WEATHER ) {
            currentWeather = Weather.getWeatherById(newWeather);
        }
    }

    public String getName() {
        return currentRooms.getName();
    }
    
    public void moveLeft()
    {
    	int id = currentRooms.getId();
    	if(id > 0) {
    		id--;
    		currentRooms = currentRooms.getRoomByID(id);
    	}
    }
    
    public void moveRight()
    {
    	int id = currentRooms.getId();
    	if(id < 2) {
    		id++;
    		currentRooms = currentRooms.getRoomByID(id);
    	}
    }
}
