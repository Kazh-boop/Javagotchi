package app.model;

import java.util.Currency;

public abstract class Familiar {


    // Familiar attributes
    protected String name;

    protected String food;
    protected int hungriness;

    protected int happiness;

    protected int hygiene;

    protected int energy;

    protected int hygiene;

    protected int vitality;

    protected Mood mood;

    private static final int MAX_STATS = 100;

    // Constructor called by childs class to init attributes value
    protected Familiar() {
        this.happiness = MAX_STATS;
        this.energy = MAX_STATS;
        this.hungriness = MAX_STATS;
        this.hygiene = MAX_STATS;
        this.vitality = MAX_STATS;
        this.mood = Mood.HAPPY;
    }

    protected Familiar(Familiar f) {
        this.energy = f.energy;
        this.happiness = f.happiness;
        this.hygiene = f.hygiene;
        this.hungriness = f.hungriness;
        this.vitality = f.vitality;
        this.mood = f.mood;
    }

    // Accessors
    public String getFood() {
        return food;
    }

    public int getHungriness() {
        return hungriness;
    }

    public void setHungriness(int hungriness) {
        if(hungriness < MAX_STATS){
            this.hungriness = hungriness;
        }
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if(happiness < MAX_STATS) {
            this.happiness = happiness;
        }
    }

    public int getHygiene(){
        return hygiene;
    }

    public void setHygiene(int hygiene){
        if(hygiene < MAX_STATS){
            this.hygiene = hygiene;
        }
        if (hygiene < 10){
            this.moodValue=moodValue-10; 
        }
    }

    public int getEnergy(){
        return energy;
    }

    public void setEnergy(int energy){
        if (energy < MAX_STATS){
            this.energy=energy;
        }
    }

    public String getMood() {
        return mood.getName();
    }

    public Mood calculateMood(Weather currentWeather, Room currentRoom) {
        int moodValue = (hungriness + happiness + hygiene + energy + vitality) / 5;

        if(moodValue >= 85) return Mood.HAPPY;
        else if(moodValue >= 70) return Mood.JOYFUL;
        else if(moodValue >= 50) return Mood.FINE;
        else if(moodValue >= 30) return Mood.SAD;

        return Mood.MISERABLE;
    }
}
