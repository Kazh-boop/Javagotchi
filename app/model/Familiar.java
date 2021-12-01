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
    
    private static final int MAX_STATS = 100;

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
        moodValue = (int)((hungriness + hygiene + energy + vitality) / 5);
        if(currentRoom == Rooms.GARDEN) moodValue*=currentWeather.getCoef();
        
        this.mood = changeMood();
    }

    public Mood changeMood() {

        if(moodValue >= 85) return Mood.HAPPY;
        else if(moodValue >= 70) return Mood.JOYFUL;
        else if(moodValue >= 50) return Mood.FINE;
        else if(moodValue >= 30) return Mood.SAD;

        return Mood.MISERABLE;
    }

    public float getMoodCoef() {
        return mood.getCoef();
    }

    public String getFamiliarType() {
        return familiarType;
    }
}
