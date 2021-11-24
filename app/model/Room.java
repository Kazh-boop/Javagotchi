package app.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Room { 
    private int currentRoom = 0;
    private Weather weather;
    private Rooms room;

    public Room() {
        
    }

    public String getWeatherName() {
        return weather.getName();
    }

    public String getImageRoom() {
        return weather.getUrl();
    }
 
    public void changeWeather(){
        int newWeather = (int) (Math.random()*100 + 1);
        if (newWeather < 5) 
            weather = Weather.SNOWY;
        else if (newWeather < 30)
        	weather = Weather.RAINY;
        else if (newWeather < 60)
        	weather = Weather.CLOUDY;
        else
        	weather = Weather.SUNNY;
    }
}
