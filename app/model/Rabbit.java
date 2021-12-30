package app.model;

public class Rabbit extends Familiar {

    //costructor
    public Rabbit(String name) {
        super();
        this.name = name;
        this.food = "Carottes"; // the rabbit can only eat carrots
        this.familiarType = "Lapin";
    }

    public Rabbit(Rabbit r) {
        super();
        r.name = name;
        this.food = "Carottes";
        this.familiarType = "Lapin";
    }
}

