package app.model;

public class Robot extends Familiar {
    
    public Robot(String name) {
        super();
        this.name = name;
        this.food = "Electricité";
        this.familiarType = "Robot";
    }

    public Robot(Robot r) {
        super();
        r.name = name;
        this.food = "Electricité";
        this.familiarType = "Robot";
    }
}
