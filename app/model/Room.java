package app.model;

public class Room { 

    private Weather weather;
    private static final int AMOUNT_OF_WEATHER = 5;
    public Rooms currentRoom;

    public Room(Rooms selectedRoom) {
        this.currentRoom = selectedRoom;
    }

    public String getWeatherName() {
        return weather.getName();
    }

    public String getImageRoom() {
        return weather.getUrl();
    }

    public double getWeatherCoef() {
        return weather.getCoeff();
    }

    public String changeWeather(){
        int newWeather = (int) (Math.random()*100 + 1);
        if(newWeather < AMOUNT_OF_WEATHER ) {
            
        }
        return null;
    }

	public void setRoom(Rooms room)
	{
		this.currentRoom = room;
	}

	public Rooms getRoom()
	{
		return this.currentRoom;
	}
}

