package app.model;

public abstract class Familiar {


    // Familiar attributes
    protected String name;

    protected String food;
    protected int hungriness;

    protected int happiness;

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

    public String getMood() {
        return mood.getName();
    }

    
}
