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
    protected TimerEnergy timerEnergy;

    protected int moodValue;

    protected String familiarType;
    
    protected String urlIcon;

    // Constants

    private static final int MAX_STATS = 100;
    private static final int MAX_FEED_PORTION = 35;
    private static final int DECREASE_STATS_PER_ACTION = 5;
    private static final int MAX_PORTIONS = 4;

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
        this.room = new Room(Rooms.LIVING_ROOM);
        this.portions = 2;
        this.timerPortions = new TimerPortions(this);
        this.timerPortions.run();
        this.timerEnergy = new TimerEnergy(this);
        this.timerEnergy.run();
    }

    protected Familiar(Familiar f) {
        this.energy = f.energy;
        this.hygiene = f.hygiene;
        this.hungriness = f.hungriness;
        this.vitality = f.vitality;
        this.mood = f.mood;
        this.room = f.room;
        this.portions = f.portions;
        this.timerPortions = new TimerPortions(f);
        this.timerPortions.run();
        this.timerEnergy = new TimerEnergy(f);
        this.timerEnergy.run();

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

    public int getHygiene(){
        return hygiene;
    }

    public void setHygiene(int hygiene){
        if(hygiene < MAX_STATS){
            this.hygiene = hygiene;
        }
        if (hygiene < 10){
            //this.moodValue -= 10;  TODO quand hygiene moins de 10% baise du mood
        }
    }

    public int getEnergy(){
        return energy;
    }

    public void setEnergy(int energy){
        if (energy < MAX_STATS){
            this.energy=energy;
        }
       /* if (energy<5){
            long timer = System.currentTimeMillis();
            int delay = 7200;
            while(System.currentTimeMillis() - timer < delay ){
                hygieneButton.setEnabled(false);
                eatButton.setEnabled(false);
                sleepButton.setEnabled(false);
                // désactiver également les boutons de déplacements !
            } 
            this.energy=100;
        }*/
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

    public Rooms getRooms(){
        return room.getRoom();
    }
}
