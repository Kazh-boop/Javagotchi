package app.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Room { 

    private Weather weather;
    private Rooms room;

    // constructor
    public Room() {
        weather = Weather.SUNNY;
        room = Rooms.LIVING_ROOM;
    }

    public String getWeatherName() {
        return weather.getName();
    }
    
	public Rooms getCurrentRoom() {
		return room;
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
	
	public void moveLeft() {
		switch(room) {
		case GARDEN:
			break;
		case KITCHEN:
			room = Rooms.LIVING_ROOM;
			break;
		case LIVING_ROOM:
			room = Rooms.GARDEN;
			break;
		default:
			break;
		}
		this.changeWeather();
	}
	
	public void moveRight() {
		switch(room) {
		case GARDEN:
			room = Rooms.LIVING_ROOM;
			break;
		case KITCHEN:
			room = Rooms.KITCHEN;
			break;
		case LIVING_ROOM:
			break;
		default:
			break;
		}
		this.changeWeather();
	}
}
