package app.model;

public class Robot extends Familiar {
    
    public Robot(String name) {
        super();
        this.name = name;
        this.food = "Electricité";
        this.familiarType = "Robot";
    }

    public Robot(Robot r) {
        super(r);
        this.food = "Electricité";
    }
    
    /**
     * Constructeur pour les tests avec un timer
     */
    public Robot(String name, long period) {
    	super(period);
        this.name = name;
        this.food = "Electricité";
        this.familiarType = "Robot";
    }
}
