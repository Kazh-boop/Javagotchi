package app.model;

import java.util.ArrayList;
import java.util.HashMap;



public class Room { 

    
    private int currentRoom = 0;
    private int currentWeather = 0;
    private HashMap<Integer, ArrayList<String>> weatherUrls;
    public String[] rooms = {
        "Cuisine",
        "Chambre",
        "Jardin"
    };

    public Room() {
        
    }


    public String getImageRoom(int nb) {
        return weatherUrls.get(currentRoom).get(currentWeather);
    }

    public String changeWeather(){
        int newWeather = (int) (Math.random()*100 + 1);
        if(newWeather < 5) {
            switch(newWeather) {
                case 0:
                    return "Sunny";
                case 1:
                    return "Cloudy";
                case 2:
                    return "Rainy";
                case 3:
                    return "Snowy";
                case 4:
                    return "Stormy";
            }
        }
        return null;
    }
}
