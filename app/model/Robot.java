package app.model;

public class Robot extends Familiar {
    
    public Robot() {
        super();
        this.food = "Electricité";
    }

    public Robot(Robot r) {
        super(r);
        this.food = "Electricité";
    }
}
