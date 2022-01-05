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
     * @throws FeedException
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
     * @throws FeedException
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

    /**
     * used for testing purpose
     */
    public void resetPortion() {
    	this.portions = MIN_PORTIONS;
    }
    
    /**
     * return the number of available portions
     * @return portions
     */
    public int getPortions() {
        return this.portions; 
    }
    
    /**
     * @param portions
     */
    public void setPortions(final int portions) {
    	if(portions <= MAX_PORTIONS) { this.portions = portions; } // allows you to change the number of portions
        if(portions < MIN_PORTIONS) this.portions = 0;
    }

    /**
     * method of washing the familiar
     * @throws WashException
     */
    public void wash() throws WashException {
    	canWash();
        setMoodValue(moodValue+MAX_RETRIEVE_STAT/NB_STATS);
    	setHygiene(hygiene + MAX_RETRIEVE_STAT);
    }
    
    /**
     * method of determining whether the familiar can be wash or not
     * @throws WashException
     */
    public void canWash() throws WashException {
    	if(hygiene == MAX_STATS) {
    		throw new WashException(name + " est déjà  tout propre !");
    	}
    	else if(room.getRooms() != Rooms.LIVING_ROOM) {
    		throw new WashException(name + " ne peut être lavé que dans le salon !");
    	}
    }
    
    /**
     * return the hygiene of the familiar
     * @return hygiene
     */
    public int getHygiene() {
        return hygiene;
    }
    
    /**
     * allows you to change the percentage of hygiene
     * @param hygiene
     */
    public void setHygiene(final int hygiene){
    	this.hygiene = hygiene;
        if(this.hygiene > MAX_STATS) this.hygiene = MAX_STATS; 
        else if(this.hygiene < MIN_STATS) this.hygiene = MIN_STATS;
    }

    /**
     * calculates the mood of the familiar according to its characteristics (hunger, hygiene, energy, vitality)
     */
    public void decreaseMood() {
        int decreaseValue = 1;
        calculateMood(decreaseValue);
    }

    /**
     * method of lowering the value of the mood
     * @param times
     */
    public void decreaseMood(int times) {
        int decreaseValue = times/NB_STATS;
        calculateMood(decreaseValue);
    }

    /**
     * method for change the mood of the familiar
     * @param decreaseValue
     */
    private void calculateMood(int decreaseValue) {
        if(room.getRooms() == Rooms.GARDEN) {
            decreaseValue*=room.getWeatherCoef();
        }
        setMoodValue(this.moodValue-decreaseValue);
        this.mood = changeMood();
    }

    /**
     * changes the mood according to the value of moodValue
     * @return Mood
     */
    public Mood changeMood() {

        if(moodValue >= HAPPY_THRESHOLD) return Mood.HAPPY;
        else if(moodValue >= JOY_THRESHOLD) return Mood.JOYFUL;
        else if(moodValue >= FINE_THRESHOLD) return Mood.FINE;
        else if(moodValue >= SAD_THRESHOLD) return Mood.SAD;

        return Mood.MISERABLE;
    }

    /**
     * @return moodValue
     */
    public int getMoodValue() {
        return moodValue;
    }

    /**
     * change the value of mood
     * @param moodValue
     */
    public void setMoodValue(final int moodValue) {
        this.moodValue = moodValue;
        if(this.moodValue > MAX_STATS) this.moodValue = MAX_STATS;
        else if(this.moodValue < MIN_STATS) this.moodValue = MIN_STATS;
        changeMood();
    }
    
    /**
     * return the coefficient used to define the familiar's mood
     * @return coef
     */
    public float getMoodCoef() {
        return mood.getCoef();
    }
    
    /**
     * return the mood of the familiar
     * @return mood
     */
    public Mood getMood() {
        return mood;
    }
    
    /**
     * allows you to change mood of the familiar
     * @param mood
     */
    public void setMood(final Mood mood) {
    	this.mood = mood;
    }
    
    /**
     * return the type of the familiar
     * @return familiarType
     */
    public String getFamiliarType() {
        return familiarType;
    }

    /**
     * method for resetting the familiar's position
     */
    public void resetPosition() {
        if(room == null) {
            this.room = new Room(Rooms.LIVING_ROOM);
        }
    }

    /**
     * return the room in which the familiar is located
     * @return room
     */
    public Room getRoom() {
        return room;
    }
    
    /**
     * allows you to change rooms
     * @param rooms
     */
    public void setRoom(final Rooms rooms ){
    	this.room.setRooms(rooms);
    }
    
    /**
     * move to the left
     */
    public void moveLeft() {
    	if(room.moveLeft()) hygiene--;
    }
    
    /**
     * move to the right
     */
    public void moveRight() {
    	if(room.moveRight()) hygiene--;
    }

    /**
     * method of allowing the familiar to sleep,
     * unless it is full of energy
     * @throws SleepException
     */
	public void sleep() throws SleepException {
    	if(energy == MAX_STATS) {
    		throw new SleepException(name + " est plein d'énergie !");
    	}
    	if(room.getRooms().equals(Rooms.GARDEN) || room.getRooms().equals(Rooms.KITCHEN)) {
    		throw new SleepException(name + " ne se trouve pas dans le " + Rooms.LIVING_ROOM.getName() + " !");
    	}
    }
    
	/**
	 * returns the energy of the familiar
	 * @return energy
	 */
    public int getEnergy() {
        return energy;
    }
    
    /**
     * allows you to change the percentage of energy
     * @param energy
     */
    public void setEnergy(final int energy) {
    	this.energy = energy;
    	if (this.energy > MAX_STATS) this.energy = MAX_STATS;
        else if (this.energy < MIN_STATS) this.energy = MIN_STATS;
    }

    /**
     * return the vitality of the familiar
     * @return vitality
     */
    public int getVitality() {
    	return vitality;
    } 

    /**
     * allows you to change the percentage of the vitality
     * @param vitality
     */
    public void setVitality(final int vitality) {
    	if (vitality <= MAX_STATS) this.vitality = vitality;
    }

    /**
     * return the name of the familiar
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * return the percentage representing the familiar's hunger
     * @return hungriness
     */
    public int getHungriness() {
        return hungriness;
    }

    /**
     * allows you to change the percentage reprenting the familiar's hunger
     * @param hungriness
     */
    public void setHungriness(final int hungriness) {
        this.hungriness = hungriness;
        if (this.hungriness > MAX_STATS) this.hungriness = MAX_STATS;
        if (this.hungriness < MIN_STATS) this.hungriness = MIN_STATS;
    }
    
    /**
     * Returns a String object representing this UUID
     * @return UUID
     */
    public String getUID() {
    	return uid.toString();
    }
    
    /**
     * Returns a String object : Nom name Type familiarType
     * @return name + type
     */
    @Override
    public String toString() {
    	return "Nom : " + name + " Type : " + familiarType;
    }
    
    /**
     * @param obj
     */
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
     * @return food
     */
    public String getFood() {
        return food;
    }
    
    /**
     * @return urlIcon
     */
    public String getUrlIcon() {
		return urlIcon;
	}
    
    /**
     * Verify if the familiar is dead or alive
     * @return boolean
     */
    public boolean isDead() {
    	return vitality == MIN_STATS || hungriness == MIN_STATS || hygiene == MIN_STATS;
    }
}