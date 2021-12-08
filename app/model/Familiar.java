package app.model;

public abstract class Familiar {


    // Familiar attributes
    protected String name;

    protected String food;

    protected int hungriness;

    protected int energy;

    protected int hygiene;

    protected int vitality;

    protected Mood mood;

    protected int moodValue;

    protected String familiarType;
    
    protected String urlIcon;

    // Constants

    private static final int MAX_STATS = 100;

    private static final int AMOUNT_OF_STATS = 5;

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
    } 

    protected Familiar(Familiar f) {
        this.energy = f.energy;
        this.hygiene = f.hygiene;
        this.hungriness = f.hungriness;
        this.vitality = f.vitality;
        this.mood = f.mood;
        this.url = 
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


    public String getMood() {
        return mood.getName();
    }


    public void recalculateMood(Weather currentWeather, Rooms currentRoom) {
        moodValue = (int)((hungriness + hygiene + energy + vitality) / AMOUNT_OF_STATS);
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

    public float getMoodCoef() {
        return mood.getCoef();
    }

    public String getFamiliarType() {
        return familiarType;
    }
}
