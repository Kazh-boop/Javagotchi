package app.model;

import java.util.ArrayList;
import java.util.HashMap;



public class Room { 


    private int currentRoom = 0;
    private Weather weather;
    private static final int AMOUNT_OF_WEATHER = 5;

    public String[] rooms = {
        "Cuisine",
        "Chambre",
        "Jardin"
    };

    public Room() {
        weather = Weather.SUNNY;
    
    }

    public String getWeatherName() {
        return weather.getName();
    }

    public String getImageRoom() {
        return weather.getUrl();
    }

    public String changeWeather(){
        int newWeather = (int) (Math.random()*100 + 1);
        if(newWeather < AMOUNT_OF_WEATHER ) {
            
        }
        return null;
    }
}
