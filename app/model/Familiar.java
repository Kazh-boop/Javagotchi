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


    // Constructor called by childs class to init attributes value
    protected Familiar() {
        this.happiness = 100;
        this.energy = 100;
        this.hungriness = 100;
        this.hygiene = 100;
        this.vitality = 100;
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

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

}
