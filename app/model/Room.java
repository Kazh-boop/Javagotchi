package app.model;

import java.util.ArrayList;
import java.util.HashMap;



public class Room { 

    private Weather weather;
<<<<<<< HEAD
    private static final int AMOUNT_OF_WEATHER = 5;

    public String[] rooms = {
        "Cuisine",
        "Chambre",
        "Jardin"
    };
=======
    private Rooms room;
>>>>>>> bf26fd7c218042407f1a5327c0856576364c28e7

    // constructor
    public Room() {
        weather = Weather.SUNNY;
        room = Rooms.LIVING_ROOM;
    }
<<<<<<< HEAD

    public String getWeatherName() {
        return weather.getName();
=======
    
    // getters
    public Weather getWeather() {
        return weather;
>>>>>>> bf26fd7c218042407f1a5327c0856576364c28e7
    }
    
	public Rooms getCurrentRoom() {
		return room;
	}

    public String getImageRoom() {
        return weather.getUrl();
    }

    
    
    public void changeWeather(){
        int newWeather = (int) (Math.random()*100 + 1);
<<<<<<< HEAD
        if(newWeather < AMOUNT_OF_WEATHER ) {
            
        }
        return null;
=======
        if (newWeather < 5) 
            weather = Weather.SNOWY;
        else if (newWeather < 30)
        	weather = Weather.RAINY;
        else if (newWeather < 60)
        	weather = Weather.CLOUDY;
        else
        	weather = Weather.SUNNY;
>>>>>>> bf26fd7c218042407f1a5327c0856576364c28e7
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
