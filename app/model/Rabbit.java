package app.model;

public class Rabbit extends Familiar {

    //costructor
    public Rabbit(String name, String url) {
        super();
        this.name = name;
        this.urlIcon = url;
        this.food = "Carottes"; // the rabbit can only eat carrots
        this.familiarType = "Lapin";
    }

    public Rabbit(Rabbit r) {
        super();
        this.name = r.name; 
        this.mood = r.mood;
        this.moodValue = r.moodValue;
        this.urlIcon = r.urlIcon;
        this.food = "Carottes";
        this.familiarType = "Lapin";
    }
}

