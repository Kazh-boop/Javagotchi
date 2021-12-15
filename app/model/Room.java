package app.model;

public class Room { 

    private Weather currentWeather;
    private static final int AMOUNT_OF_WEATHER = 5;
    public Rooms currentRoom;
    
    // seuil changement de la meteo
    private static final int SUN_THRESHOLD = 60; 	// a partir de 60
    private static final int CLOUD_THRESHOLD = 30;	// a partir de 30
    private static final int RAINY_THRESHOLD = 10;	// a partir de 10

    public Room(Rooms selectedRoom) {
        this.currentRoom = selectedRoom;
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

    private void setWeather(Weather weather) {
    	this.currentWeather = weather;
    }

	public void setRoom(Rooms room)
	{
		this.currentRoom = room;
	}

	public Rooms getRoom()
	{
		return this.currentRoom;
	}
    
    public void changeWeather() {
    	int thresholdWeather = (int)(Math.random()*100);
    	if (thresholdWeather >= SUN_THRESHOLD) // [60-100]
    		setWeather(Weather.SUNNY);
    	else if (thresholdWeather >= CLOUD_THRESHOLD) // [30-59]
    		setWeather(Weather.CLOUDY);
    	else if (thresholdWeather >= RAINY_THRESHOLD) // [10-29]
    		setWeather(Weather.RAINY);
    	else // [0-9]
    		setWeather(Weather.SNOWY);
    }
    
    private void changeRoom(Rooms room) {
    	this.currentRoom = room;
    }
    
    public void moveLeft() {
    	switch (currentRoom) {
    	case KITCHEN:
    		changeRoom(Rooms.LIVING_ROOM);	// changement piece
    		changeWeather(); 				// changement meteo
    		break;
    	case LIVING_ROOM:
    		changeRoom(Rooms.GARDEN);	// changement piece
    		changeWeather();			// changement meteo
    		break;
    	default:
    		break;
    	}
    }
    
    public void moveRight() {
    	switch (currentRoom) {
    	case GARDEN:
    		changeRoom(Rooms.LIVING_ROOM);	// changement piece
    		changeWeather(); 				// changement meteo
    		break;
    	case LIVING_ROOM:
    		changeRoom(Rooms.KITCHEN);	// changement piece
    		changeWeather();			// changement meteo
    		break;
    	default:
    		break;
    	}
    }
    
}

