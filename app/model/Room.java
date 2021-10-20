package app.model;

import java.util.ArrayList;
import java.util.HashMap;



public class Room { 


    private int currentRoom = 0;
    private Weather weather;
    

    public String[] rooms = {
        "Cuisine",
        "Chambre",
        "Jardin"
    };

    public Room() {
        weather = Weather.SUNNY;
    
    }

    public getWeatherName() {
        return weather.getName();
    }

    public String getImageRoom() {
        return weather.getUrl();
    }

    public String changeWeather(){
        int newWeather = (int) (Math.random()*100 + 1);
        if(newWeather < 5) {
            
        }
        return null;
    }
}
