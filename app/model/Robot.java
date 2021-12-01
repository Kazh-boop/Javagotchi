package app.model;

public class Robot extends Familiar {
    
    public Robot() {
        super();
        this.food = "Electricité";
        this.familiarType = "Robot";
    }

    public Robot(Robot r) {
        super(r);
        this.food = "Electricité";
    }
}
