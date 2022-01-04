package app.model;

import java.io.Serializable;
import java.util.UUID;

import app.exceptions.*;


public abstract class Familiar implements Serializable {
	
	// allows to identify each Familiar in a unique way
	private final UUID uid = UUID.randomUUID();
	private static final long serialVersionUID = 1L;

    // Familiar attributes
    protected String name;
    protected String food;
    protected int hungriness;
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
    private static final int MIN_STATS = 0;

    
    // food
    private static final int NB_STATS = 3;
    private static final int MAX_RETRIEVE_STAT = 35;
    private static final int DECREASE_STATS_PER_ACTION = 5;
    private static final int MAX_PORTIONS = 4;
    private static final int MIN_PORTIONS = 0;

    // mood
    private static final int HAPPY_THRESHOLD = 85;
    private static final int JOY_THRESHOLD = 70;
    private static final int FINE_THRESHOLD = 55;
    private static final int SAD_THRESHOLD = 35;
        
    // Constructor called by childs class to init attributes value
    protected Familiar() {
        this.energy = MAX_STATS;
        this.hungriness = MAX_STATS;
        this.hygiene = MAX_STATS;
        this.vitality = MAX_STATS;
        this.mood = Mood.HAPPY;
        this.moodValue = MAX_STATS;
        this.room = new Room(Rooms.LIVING_ROOM);
        this.portions = 2;
    }

    /**
     * method of feeding the familiar
     */

    public void feed() throws FeedException {
            // check if familiar can be fed and change linked value if yes
            canBeFeed();
            setHungriness(this.hungriness + MAX_RETRIEVE_STAT);
            setMoodValue(moodValue+MAX_RETRIEVE_STAT/NB_STATS);

            this.energy -= DECREASE_STATS_PER_ACTION;
            this.hygiene -= DECREASE_STATS_PER_ACTION;
            decreaseMood(DECREASE_STATS_PER_ACTION*2);
            setPortions(portions-1);
    }


    /**
     * method of determining whether the familiar can be fed or not
     */
    public void canBeFeed() throws FeedException {
    	if(hungriness == MAX_STATS)
    	{
    		throw new FeedException("Le familier est repu !");
    	}
    	else if(room.getRooms() != Rooms.KITCHEN) {
    		throw new FeedException("Le familier ne peut être nourri que dans la cuisine !");
    	}
    	else if(this.portions <= MIN_PORTIONS) {
    		throw new FeedException("Vous n'avez plus de portions !");
    	}
    }
    
    /**
     * method for add a portion
     */ 

    public void addPortion() {
        if(this.portions < MAX_PORTIONS) setPortions(portions++);
    }

    // used for testing
    public void resetPortion() {
    	this.portions = MIN_PORTIONS;
    }
    
    public int getPortions() {
        return this.portions; // return the number of available portions
    }
    
    public void setPortions(final int portions) {
    	if(portions <= MAX_PORTIONS) { this.portions = portions; }// allows you to change the number of portions
        if(portions < MIN_PORTIONS) this.portions = 0;
    }

    /**
     * method of washing the familiar
     */
    
    public void wash() throws WashException {
    	canWash();
        setMoodValue(moodValue+MAX_RETRIEVE_STAT/NB_STATS);
    	setHygiene(hygiene + MAX_RETRIEVE_STAT);
    }
    
    /**
     * method of determining whether the familiar can be wash or not
     */
    public void canWash() throws WashException {
    	if(hygiene == MAX_STATS) {
    		throw new WashException(name + " est déjà tout propre !");
    	}
    	else if(room.getRooms() != Rooms.LIVING_ROOM) {
    		throw new WashException(name + "ne peut être lavé que dans le salon !");
    	}
    }
    
    public int getHygiene() {
        return hygiene; // return the hygiene of the familiar
    }
    
    // allows you to change the percentage of hygiene
    public void setHygiene(final int hygiene){
    	this.hygiene = hygiene;
        if(this.hygiene > MAX_STATS) this.hygiene = MAX_STATS; 
        else if(this.hygiene < MIN_STATS) this.hygiene = MIN_STATS;
    }

    // calculates the mood of the familiar according to its characteristics (hunger, hygiene, energy, vitality)
    public void decreaseMood() {
        int decreaseValue = 1;
        calculateMood(decreaseValue);
    }

    public void decreaseMood(int times) {
        int decreaseValue = times/NB_STATS;
        calculateMood(decreaseValue);
    }

    private void calculateMood(int decreaseValue) {
        if(room.getRooms() == Rooms.GARDEN) {
            decreaseValue*=room.getWeatherCoef();
        }
        setMoodValue(this.moodValue-decreaseValue);
        this.mood = changeMood();
    }

    // changes the mood according to the value of moodValue
    public Mood changeMood() {

        if(moodValue >= HAPPY_THRESHOLD) return Mood.HAPPY;
        else if(moodValue >= JOY_THRESHOLD) return Mood.JOYFUL;
        else if(moodValue >= FINE_THRESHOLD) return Mood.FINE;
        else if(moodValue >= SAD_THRESHOLD) return Mood.SAD;

        return Mood.MISERABLE;
    }

    public int getMoodValue() {
        return moodValue;
    }

    public void setMoodValue(final int moodValue) {
        this.moodValue = moodValue;// change the value of mood
        if(this.moodValue > MAX_STATS) this.moodValue = MAX_STATS;
        else if(this.moodValue < MIN_STATS) this.moodValue = MIN_STATS;
        changeMood();
    }
    
    public float getMoodCoef() {
        return mood.getCoef(); // return the coefficient used to define the familiar's mood
    }
    
    public Mood getMood() {
        return mood; // return the mood of the familiar
    }
    
    public void setMood(final Mood mood) {
    	this.mood = mood; // allows you to change mood of the familiar
    }

    public String getFamiliarType() {
        return familiarType; // return the type of the famailiar
    }

    /**
     * method for resetting the familiar's position
     */ 

    public void resetPosition() {
        if(room == null) {
            this.room = new Room(Rooms.LIVING_ROOM);
        }
    }

    public Rooms getRoom() {
        return room.getRooms(); // return the room in which the familiar is located
    }
    
    public void setRoom(final Rooms rooms ){
    	this.room.setRooms(rooms);  // allows you to change rooms
    }
    
    public void moveLeft() {
    	if(room.moveLeft()) hygiene--; // move to the left
    }
    
    public void moveRight() {
    	if(room.moveRight()) hygiene--; // move to the right
    }
    

    /**
     * method of allowing the familiar to sleep,
     * unless it is full of energy
     */

    public void sleep() throws SleepException {
    	if(energy == MAX_STATS) {
    		throw new SleepException(name + " est plein d'énergie !");
    	}
    }
    
    public int getEnergy() {
        return energy; // returns the energy of the familiar
    }
    
    public void setEnergy(final int energy) {
    	this.energy = energy;
    	if (this.energy > MAX_STATS) this.energy = MAX_STATS; // allows you to change the percentage of energy
        else if (this.energy < MIN_STATS) this.energy = MIN_STATS; // allows you to change the percentage of energy

    }

    public int getVitality() {
    	return vitality; // return the vitality of the familiar
    } 
    
    public void setVitality(final int vitality) {
    	if (vitality <= MAX_STATS) this.vitality = vitality;
    }

    public String getName() {
        return name; // return the name of the familiar
    }
    
    public int getHungriness() {
        return hungriness; // return the percentage representing the familiar's hunger
    }

    public void setHungriness(final int hungriness) {
        this.hungriness = hungriness;
        if (this.hungriness > MAX_STATS) this.hungriness = MAX_STATS; // allows you to change the percentage reprenting the familiar's hunger
        if (this.hungriness < MIN_STATS) this.hungriness = MIN_STATS;
    }
    
    public String getUID() {
    	return uid.toString();
    }
    
    @Override
    public String toString() {
    	return "Nom : " + name + " Type : " + familiarType;
    }
    
    @Override
    public boolean equals(final Object obj) {
    	
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

    	if(obj == this) return true;
    	final Familiar fam = (Familiar) obj;
    	return this.name.equals(fam.getName());
    }

    /**
     * return the familiar's food
     */

    public String getFood() {
        return food;
    }
    
    public String getUrlIcon() {
		return urlIcon;
	}
    
    public boolean isDead() {
    	return vitality == MIN_STATS || hungriness == MIN_STATS || hygiene == MIN_STATS;
    }
}