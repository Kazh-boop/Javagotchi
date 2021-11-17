package app.model;

public class Rabbit extends Familiar {
    public Rabbit() {
        super();
        this.food = "Carrottes";
    }

    public Rabbit(Rabbit r) {
        super(r);
        this.food = "Carottes";
    }
}

