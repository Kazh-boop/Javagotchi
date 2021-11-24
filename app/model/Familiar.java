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
    protected Room room;
    protected int portions;
    
    protected TimerPortions timerPortions;

    private static final int MAX_STATS = 100;
    private static final int MAX_FEED_PORTION = 35;
    private static final int DECREASE_STATS_PER_ACTION = 5;
    private static final int MAX_PORTIONS = 4;

    // Constructor called by childs class to init attributes value
    protected Familiar() {
        this.happiness = MAX_STATS;
        this.energy = MAX_STATS;
        this.hungriness = MAX_STATS;
        this.hygiene = MAX_STATS;
        this.vitality = MAX_STATS;
        this.mood = Mood.HAPPY;
        this.room = new Room(Rooms.LIVING_ROOM);
        this.portions = 2;
        this.timerPortions = new TimerPortions(this);
        this.timerPortions.run();
    }

    protected Familiar(Familiar f) {
        this.energy = f.energy;
        this.happiness = f.happiness;
        this.hygiene = f.hygiene;
        this.hungriness = f.hungriness;
        this.vitality = f.vitality;
        this.mood = f.mood;
        this.room = f.room;
        this.portions = f.portions;
        this.timerPortions = new TimerPortions(f);
        this.timerPortions.run();
    }

    // Accessors
    public String getFood() {
        return food;
    }

    public int getHungriness() {
        return hungriness;
    }

    public void setHungriness(int hungriness) {
        this.hungriness = hungriness;
    }

    public void feed() {
        if(hungriness < MAX_STATS && this.room.getRoom() == Rooms.KITCHEN && this.portions > 0){
            // we can only feed him whith 35% of the hungriness
            this.hungriness += MAX_FEED_PORTION;
            this.energy -= DECREASE_STATS_PER_ACTION;
            this.hygiene -= DECREASE_STATS_PER_ACTION;
        }else{
            // TODO indiquer à l'utilisateur qu'il ne peut pas le nourrir
        }
    }

    public void addPortion()
    {
        if(this.portions < MAX_PORTIONS)
        {
            this.portions++;
        }
    }

    public int getPortions()
    {
        return this.portions;
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

    public Mood calculateMood(Weather currentWeather, Room currentRoom) {
        int moodValue = (hungriness + happiness + hygiene + energy + vitality) / 5;

        if(moodValue >= 85) return Mood.HAPPY;
        else if(moodValue >= 70) return Mood.JOYFUL;
        else if(moodValue >= 50) return Mood.FINE;
        else if(moodValue >= 30) return Mood.SAD;

        return Mood.MISERABLE;
    }
}
