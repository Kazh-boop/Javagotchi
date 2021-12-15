package app.model;

public class Rabbit extends Familiar {
    public Rabbit(String name) {
        super();
        this.name = name;
        this.food = "Carottes";
        this.familiarType = "Lapin";
    }

    public Rabbit(Rabbit r) {
        super(r);
        this.food = "Carottes";
    }
    
    /**
     * Constructeur pour les tests avec un timer
     */
    public Rabbit(String name, long period) {
    	super(period);
        this.name = name;
        this.food = "Carottes";
        this.familiarType = "Lapin";
    }
}

