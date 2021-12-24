package app.model;

import java.io.Serializable;
import java.util.UUID;

public abstract class Familiar implements Serializable {
	
	// permet d'identifier chaque Familiar de maniere unique
	private final UUID uid = UUID.randomUUID();
	private static final long serialVersionUID = 1L;

    // Familiar attributes
    protected String name;
    protected String food;
    protected int hungriness;
    protected int happiness;
    protected int energy;
    protected int hygiene;
    protected int vitality;
    protected Mood mood;
    protected transient Room room;
    protected int portions;

    protected int moodValue;

    protected String familiarType;
    protected String urlIcon;

    // Constants

    private static final int MAX_STATS = 100;

    private static final int AMOUNT_OF_STATS = 5;
    
    // food
    private static final int MAX_FEED_PORTION = 35;
    private static final int DECREASE_STATS_PER_ACTION = 5;
    private static final int MAX_PORTIONS = 4;

    // mood
    private static final int HAPPY_THRESHOLD = 85;
    private static final int JOY_THRESHOLD = 70;
    private static final int FINE_THRESHOLD = 55;
    private static final int SAD_THRESHOLD = 35;
    
    // Constructor called by childs class to init attributes value
    protected Familiar() {
        this.energy = MAX_STATS;
        this.hungriness = MAX_STATS;
        this.happiness = 100;
        this.hygiene = MAX_STATS;
        this.vitality = MAX_STATS;
        this.mood = Mood.HAPPY;
        this.room = new Room(Rooms.LIVING_ROOM);
        this.portions = 2;
    }

    public void feed(Rooms currentRoom) {
        if(hungriness < MAX_STATS && currentRoom == Rooms.KITCHEN && this.portions > 0){
            // we can only feed him with 35% of the hungriness
            setHungriness(this.hungriness + MAX_FEED_PORTION);
            this.energy -= DECREASE_STATS_PER_ACTION;
            this.hygiene -= DECREASE_STATS_PER_ACTION;
            this.portions--;
        }else{
            // TODO indiquer à l'utilisateur qu'il ne peut pas le nourrir
        }
    }

    public void addPortion() {
        if(this.portions < MAX_PORTIONS) this.portions++;
    }

    // utilisee pour les tests
    public void ResetPortion() {
    	this.portions = 0;
    }
    
    public int getPortions() {
        return this.portions;
    }
    
    public void setPortions(int portions) {
    	if(portions <= MAX_PORTIONS) this.portions = portions;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if(happiness < MAX_STATS) {
            this.happiness = happiness;
        }
    }
    
    public int getHygiene() {
        return hygiene;
    }
    
    public void setHygiene(int hygiene){
        if(hygiene < MAX_STATS){
            this.hygiene = hygiene;
        }
    }
    
    public void recalculateMood(Weather currentWeather, Rooms currentRoom) {
        moodValue = (hungriness + hygiene + energy + vitality) / AMOUNT_OF_STATS;
        if(currentRoom == Rooms.GARDEN) moodValue*=currentWeather.getCoef();
        
        this.mood = changeMood();
    }

    public Mood changeMood() {

        if(moodValue >= HAPPY_THRESHOLD) return Mood.HAPPY;
        else if(moodValue >= JOY_THRESHOLD) return Mood.JOYFUL;
        else if(moodValue >= FINE_THRESHOLD) return Mood.FINE;
        else if(moodValue >= SAD_THRESHOLD) return Mood.SAD;

        return Mood.MISERABLE;
    }
    
    public void setMoodValue(int moodValue) {
    	this.moodValue = moodValue;
    }
    
    public float getMoodCoef() {
        return mood.getCoef();
    }
    
    public Mood getMood() {
        return mood;
    }
    
    public void setMood(Mood mood) {
    	this.mood = mood;
    }

    public String getFamiliarType() {
        return familiarType;
    }

    public Rooms getRoom() {
        return room.getRooms();
    }
    
    public void setRoom(Rooms rooms)
    {
    	this.room.setRooms(rooms);
    }
    
    public void moveLeft()
    {
    	room.moveLeft();
    }
    
    public void moveRight()
    {
    	room.moveRight();
    }
    
    public int getEnergy() {
        return energy;
    }
    
    public void setEnergy(int energy) {
    	this.energy = energy;
    	if (this.energy > MAX_STATS) this.energy = MAX_STATS;
    }
    
    public int getVitality() {
    	return vitality;
    }
    
    public void setVitality(int vitality) {
    	if (vitality <= MAX_STATS) this.vitality = vitality;
    }

    public String getName() {
        return name;
    }
    
    public int getHungriness() {
        return hungriness;
    }

    public void setHungriness(int hungriness) {
        this.hungriness = hungriness;
        if (this.hungriness > MAX_STATS) this.hungriness = MAX_STATS;
    }
    
    public String getUID() {
    	return uid.toString();
    }
    
    @Override
    public String toString() {
    	return "Nom : " + name + " Type : " + familiarType;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(obj == null) return false;
    	if(obj == this) return true;
    	Familiar fam = (Familiar) obj;
    	return this.name.equals(fam.getName());
    }
}
