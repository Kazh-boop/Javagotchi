package app.model;




public class Room { 

    private Weather currentWeather;
    private static final int AMOUNT_OF_WEATHER = 5;
    public Rooms currentRoom;

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

    public String changeWeather(){
        int newWeather = (int) (Math.random()*100 + 1);
        if(newWeather < AMOUNT_OF_WEATHER ) {
            
        }
        return null;
    }
}
