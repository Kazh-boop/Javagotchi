package app.model;

import java.util.Random;

public class Room { 

    private Weather currentWeather;
    private static final int AMOUNT_OF_WEATHER = 5;
    public Rooms currentRoom;

    public Room(Rooms selectedRoom) {
        this.currentRoom = selectedRoom;
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
    
    public Rooms getRoom()
    {
    	return currentRoom;
    }

    public void changeWeather() {
         Random ran = new Random();

        int newWeather = (int) (ran.nextInt(100));
        if(newWeather < AMOUNT_OF_WEATHER ) {
            currentWeather = Weather.getWeatherById(newWeather);
        }
    }

    public String getName() {
        return currentRoom.getName();
    }
}
