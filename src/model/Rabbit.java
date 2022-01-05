package model;

public class Rabbit extends Familiar {

	/**
     * Constructor
     * @param name
     * @param url
     */
    public Rabbit(String name, String url) {
        super();
        this.name = name;
        this.urlIcon = url;
        this.food = "Carottes"; // the rabbit can only eat carrots
        this.familiarType = "Lapin";
    }

    /**
     * @param rabbit
     */
    public Rabbit(Rabbit rabbit) {
        super();
        this.name = rabbit.name; 
        this.mood = rabbit.mood;
        this.moodValue = rabbit.moodValue;
        this.urlIcon = rabbit.urlIcon;
        this.food = "Carottes";
        this.familiarType = "Lapin";
    }
}

